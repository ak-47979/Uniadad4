package ec.edu.ec.web.resource;




import java.util.List;

import ec.edu.ec.application.service.ReporteService;
import ec.edu.ec.domain.model.Reporte;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/reportes")
public class ReporteResource {
    @Inject
    private ReporteService reporteService;
    //reporte/todos
   
    //Escuchando en el puerto: http://localhost:8081/reportes/porId/{id}
    //{id} es el nombre parametro que recibe como parametro definido en PathParam
    @Path("/porId/{id}")
    @GET
    public Reporte buscarporId(@PathParam("id") Integer Id){
        return this.reporteService.buscaReporteId(Id);
    }

    //Escuchando en el puerto: http://localhost:8081/reportes/todos
    @Path("/todos")    
    @GET  
    public List<Reporte> buscarTodos(){
        return this.reporteService.buscarTodos();
    }

    //Escuchando en el puerto: http://localhost:8081/reportes/guardar
    @Path("/guardar")
    @POST
    public void guardar(Reporte reporte){
        this.reporteService.crearReporte(reporte);
    }

     //Escuchando en el puerto: http://localhost:8081/reportes/actualizar
    @Path("/actualizar/{id}")
    @PUT
    public void actualizar(Reporte reporte, @PathParam("id") Integer id){
        this.reporteService.actualizarReporte(reporte, id);
    }
 
     //Escuchando en el puerto: http://localhost:8081/reportes/actualizar
    @Path("/eliminar")
    @DELETE
    public void eliminar(Integer id){
        this.reporteService.eliminarReporteId(id);
    }

}
