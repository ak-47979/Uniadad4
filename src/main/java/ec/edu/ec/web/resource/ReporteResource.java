package ec.edu.ec.web.resource;




import java.util.List;

import ec.edu.ec.application.service.ReporteService;
import ec.edu.ec.domain.model.Reporte;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/reportes")
public class ReporteResource {
    @Inject
    private ReporteService reporteService;
    //reporte/todos
    
    public Reporte buscarporId(Integer Id){
        return this.reporteService.buscaReporteId(Id);
    }

    
    @Path("/todos")
    @GET    public List<Reporte> buscarTodos(){
        return this.reporteService.buscarTodos();
    }
}
