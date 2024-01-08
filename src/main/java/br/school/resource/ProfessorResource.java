package br.school.resource;

import br.school.dto.ProfessorDTO;
import br.school.service.ProfessorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.net.URI;
import java.util.List;

@Path("/professor")
@Tag(name = "Professor")
@Produces(MediaType.APPLICATION_JSON )
@Consumes(MediaType.APPLICATION_JSON)
public class ProfessorResource {

    @Inject
    ProfessorService  professorService;

    @GET
    public List<ProfessorDTO> listProf() {
        return professorService.listarProf();
    }

    @POST
    public Response createProfessor(@RequestBody ProfessorDTO professorDTO){
        ProfessorDTO Professor = professorService.criarProf(professorDTO);
        return Response.created(URI.create("/professor/")).entity(Professor).build();
    }

    @PUT
    @Path("/{id}")
    public ProfessorDTO editar(@PathParam("id")Long id, @RequestBody ProfessorDTO professor){
        return professorService.editar(id, professor);
    }
}
