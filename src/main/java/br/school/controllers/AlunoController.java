package br.school.controllers;


import br.school.dto.AlunoDTO;
import br.school.dto.ListaAlunoCursoDTO;
import br.school.service.AlunoService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.net.URI;
import java.util.List;



@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/alunos")
@Tag(name = "Alunos")
public class AlunoController {


    @Inject
    AlunoService alunoService;

    @Operation(summary = "Listar todos",description= "Lista todos os alunos cadastrados")
    @GET
    public List<AlunoDTO> listarAluno() {
        return alunoService.listar();
    }

    @Operation(summary = "Buscar aluno",description= "Realizar uma busca individual pelo ID")
    @GET
    @Path("/{id}")
    public AlunoDTO buscarAlunoID(
            @Parameter(description = "Id do Aluno", required = true)
            @PathParam("id")Long id){
        return alunoService.buscarPorId(id);
    }

    @Operation(summary = "Listar o curso por aluno ",description= "Listar o curso que o aluno esta")
    @GET
    @Path("{id}/cursos/")
    public ListaAlunoCursoDTO buscarAlunoCursoID(
            @Parameter(description = "Id do Aluno", required = true)
            @PathParam("id")Long id){
        return alunoService.buscarAlunoPorId(id);
    }

    @Operation(summary = "Cadastro de aluno",description= "Cadastrar aluno")
    @APIResponse(responseCode = "201",description = "Cadastrar Aluno",
            content =  @Content(mediaType = MediaType.APPLICATION_JSON,
                    schema =   @Schema(implementation = AlunoDTO.class )))
    @POST
    public Response createAluno(@RequestBody AlunoDTO aluno){
        AlunoDTO alunodto = alunoService.criar(aluno);
        return Response.created(URI.create("/alunos")).entity(alunodto).build();
    }

    @Operation(summary = "Editar aluno",description= "editar aluno")
    @PUT
    @Path("/{id}")
    public AlunoDTO updateAluno(
            @Parameter(description = "Id do Aluno", required = true)
            @PathParam("id")Long id,
            @RequestBody AlunoDTO aluno){
        return alunoService.editar(id, aluno);
    }

    @Operation(summary = "Deletar aluno",description= "Ao deletar o aluno não sera possivel recuperar")
    @DELETE
    @Path("/{id}")
    @Transactional
    public void deleteAluno(
            @Parameter(description = "Id do Aluno", required = true)
            @PathParam("id") Long id) {
        alunoService.deletar(id);}

}