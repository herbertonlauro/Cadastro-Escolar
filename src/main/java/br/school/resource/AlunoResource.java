package br.school.resource;


import br.school.dto.AlunoDTO;
import br.school.service.AlunoService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.net.URI;
import java.util.List;



@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/alunos")
@Tag(name = "Alunos")
public class AlunoResource {


    @Inject
    AlunoService alunoService;

    @GET
    public List<AlunoDTO> listarAluno() {
        return alunoService.listar();
    }

    @GET
    @Path("/{id}")
    public AlunoDTO buscarAlunoID(@PathParam("id")Long id){

        return alunoService.buscarPorId(id);
    }

    @POST
    public Response createAluno(AlunoDTO aluno){
        AlunoDTO alunodto = alunoService.criar(aluno);
        return Response.created(URI.create("/alunos")).entity(alunodto).build();
    }

    @POST
    @Path("/{idAluno}/cursos/{idCurso}")
    public Response adicionarAluno(@PathParam("idAluno") Long id,@PathParam("idCurso") Long idCurso){
        alunoService.adicionarAlunoCurso(id, idCurso);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    public AlunoDTO updateAluno(@PathParam("id")Long id,@RequestBody AlunoDTO aluno){
        return alunoService.editar(id, aluno);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteAluno(@PathParam("id") Long id) {
        alunoService.deletar(id);
        return Response.noContent().build();
    }

}