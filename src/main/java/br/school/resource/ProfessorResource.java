package br.school.resource;

import br.school.dto.CursoDTO;
import br.school.dto.ProfessorDTO;
import br.school.service.ProfessorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
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
        return professorService.listarProfessor();
    }

    @POST
    public Response createProfessor(ProfessorDTO professorDTO){
        ProfessorDTO Professor = professorService.criar(professorDTO );
        return Response.created(URI.create("/professor/")).entity(Professor).build();

    }
}
