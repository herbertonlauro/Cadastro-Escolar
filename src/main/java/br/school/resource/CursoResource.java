package br.school.resource;

import br.school.dto.AlunoDTO;
import br.school.dto.CursoDTO;
import br.school.service.CursoService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.net.URI;
import java.util.List;

@Path("/cursos")
@Tag(name = "Cursos")
@Produces(MediaType.APPLICATION_JSON )
@Consumes(MediaType.APPLICATION_JSON)
public class CursoResource {

    @Inject
    CursoService cursoService;

    @Operation(summary = "Listar todos",description= "Lista todos os Cursos cadastrados")
    @GET
    public List<CursoDTO> list() {
        return cursoService.listarCurso();
    }
    @Operation(summary = "Listar Aluno por Curso",description= "Buscar alunos por um curso")
    @GET
    @Path("/{idCurso}")
    public List<AlunoDTO> ListarCursoAluno(@PathParam("idCurso") Long id){
        return cursoService.ListarCursoAluno(id);

    }

    @Operation(summary = "Cadastrar  Curso",description= "Ao cadastrar um curso, preencher todos os campos, no campo turno escolha umas das opções Matutino/vespertino/Noturno")
    @POST
    @Transactional
    public Response createCurso(CursoDTO cursoDTO){
        CursoDTO curso = cursoService.criar(cursoDTO );
        return Response.created(URI.create("/cursos/")).entity(curso).build();

    }
    @Operation(summary = "Adicionar aluno ao curso",description= "Vincular o aluno com o curso")
    @POST
    @Path("/{idCurso}/alunos/{idAluno}")
    @Transactional
    public Response adicionarAluno(@PathParam("idCurso") Long idCurso, @PathParam("idAluno") Long id){
        cursoService.adicionarAlunoCurso(id, idCurso);
        return Response.ok().build();
    }


    @Operation(summary = "Editar um Curso",description= "Ao editar um curso deve se atentar para os campos obrigatorios")
    @PUT
    @Path("/{idCurso}")
    @Transactional
    public CursoDTO updateCurso(@PathParam("idCurso")Long id, @RequestBody CursoDTO curso){
        return cursoService.editar(id, curso);
    }

    @Operation(summary = "Deletar um Curso",description= "Só pode deletar curso que não tenha aluno.")
    @DELETE
    @Path("/{idCurso}")
    @Transactional
    public void deletarCurso(@PathParam("idCurso")Long id){
        cursoService.deletar(id); }
}
