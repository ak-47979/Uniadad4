package ec.edu.ec.web.resource;

import ec.edu.ec.application.service.TransferenciaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/transferencia")
public class RecursoTransferencia {
 
    @Inject
    private TransferenciaService ts;
 
    //http://localhost:8080/transferencia/realizar
    @Path("/realizar")
    @POST
    public String realizarTransferencia(TransferenciaResource resources) throws InterruptedException{
        return this.ts.realizarTransferencia(resources.getCuentaOrigen(),
        resources.getCuentaDestino(),
        resources.getMonto());
    }

    @Path("/realizarReactiva")
    @POST
    public String realizarTransferenciaReactiva(TransferenciaResource resources) throws InterruptedException{
        return this.ts.realizarTransferencia(resources.getCuentaOrigen(),
        resources.getCuentaDestino(),
        resources.getMonto());
    }
}
    