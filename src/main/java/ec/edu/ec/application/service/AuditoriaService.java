package ec.edu.ec.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class AuditoriaService {
public void guardarAuditoria(String auditoria) {
    long inicio = System.nanoTime();

    Thread hilo = Thread.currentThread();

    System.out.println("Hilo: " + hilo.getName() +
            " | ID: " + hilo.threadId());

    System.out.println("Se registra la auditoría: " + auditoria);

    long tiempoMs = (System.nanoTime() - inicio) / 1_000_000;

    System.out.println("Hilo: " + hilo.getName() +
            " | ID: " + hilo.threadId() +
            " | Tiempo ejecución: " + tiempoMs + " ms");
}


}
