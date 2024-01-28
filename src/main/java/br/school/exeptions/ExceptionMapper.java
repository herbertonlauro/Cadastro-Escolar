package br.school.exeptions;

import br.school.dto.ErroResponse;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

public class ExceptionMapper {

    @ServerExceptionMapper
    public Response tratarRuntime(RuntimeException runtimeException ){
        ErroResponse erro = new ErroResponse();
        erro.setMessagem(runtimeException.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).entity(erro).build();
    }
}
