package br.school.resource;

import br.school.dto.AlunoDTO;
import br.school.dto.CursoDTO;
import br.school.service.CursoService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
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

    @GET
    public List<CursoDTO> list() {
        return cursoService.listarCurso();
    }
    @GET
    @Path("/{idCurso}")
    public List<AlunoDTO> ListarCursoAluno(@PathParam("idCurso") Long id){
        return cursoService.ListarCursoAluno(id);

    }


    @POST
    @Transactional
    public Response createCurso(CursoDTO cursoDTO){
        CursoDTO curso = cursoService.criar(cursoDTO );
        return Response.created(URI.create("/cursos/")).entity(curso).build();

    }
    @POST
    @Path("/{idCurso}/aluno/{idAluno}")
    @Transactional
    public Response adicionarAluno(@PathParam("idCurso") Long idCurso, @PathParam("idAluno") Long id){
        cursoService.adicionarAlunoCurso(id, idCurso);
        return Response.ok().build();
    }

    @PUT
    @Path("/{idCurso}")
    @Transactional
    public CursoDTO updateCurso(@PathParam("idCurso")Long id, @RequestBody CursoDTO curso){
        return cursoService.editar(id, curso);
    }

    @DELETE
    @Path("/{idCurso}")
    @Transactional
    public void deletarCurso(@PathParam("idCurso")Long id){
        cursoService.deletar(id); }
}
