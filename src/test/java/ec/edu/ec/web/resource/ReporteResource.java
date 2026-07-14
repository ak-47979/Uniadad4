package ec.edu.ec.web.resource;

import com.google.inject.Inject;

import ec.edu.ec.application.service.ReporteService;
import ec.edu.ec.domain.model.Reporte;

public class ReporteResource {
    @Inject
    private ReporteService reporteService;
    public Reporte buscarporId(Integer Id){
        return this.reporteService.buscaReporteId(Id);
    }
}
