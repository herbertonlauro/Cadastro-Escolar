package br.school.resource;

import br.school.dto.ProfessorDTO;
import br.school.service.ProfessorService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.net.URI;
import java.util.List;

@Path("/professores")
@Tag(name = "Professores")
@Produces(MediaType.APPLICATION_JSON )
@Consumes(MediaType.APPLICATION_JSON)
public class ProfessorResource {

    @Inject
    ProfessorService  professorService;

    @GET
    public List<ProfessorDTO> listar() {
        return professorService.listar();
    }

    @POST
    public Response criar(@RequestBody ProfessorDTO professorDTO){
        ProfessorDTO Professor = professorService.criar(professorDTO);
        return Response.created(URI.create("/professor/")).entity(Professor).build();
    }

    @PUT
    @Path("/{id}")
    public ProfessorDTO editar(@PathParam("id")Long id, @RequestBody ProfessorDTO professor){
        return professorService.editar(id, professor);
    }

    @Operation(summary = "Deletar o registro",description= "Ao deletar o aluno não sera possivel recuperar")
    @DELETE
    @Path("/{id}")
    @Transactional
    public void deletar(@Parameter(description = "id do registro ", required = true)
                            @PathParam("id") Long id){
        professorService.deletar(id);
    }
}
