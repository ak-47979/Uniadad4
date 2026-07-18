package ec.edu.ec.application.service;

import java.math.BigDecimal;
 
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
 
@ApplicationScoped
@Transactional
public class TransferenciaService {
 
    @Inject
    private CuentaBancariaService cbs;
    @Inject
    private MailService ms;
    @Inject
    private AuditoriaService as;
 
    // Sinpromesa
    public String realizarTransferencia(String cuentaOrigen,
            String cuentaDestino,
            BigDecimal monto) throws InterruptedException {
 
        System.out.println("ID: " + Thread.currentThread().getName());
 
        long inicio = System.nanoTime();
 
        BigDecimal saldoDestino = this.cbs.agregaMonto(cuentaDestino, monto);
        BigDecimal saldoOrigen = this.cbs.restaMonto(cuentaOrigen, monto);
 
        this.ms.enviarMail(
                "psaguasl@uce.edu.ec",
                "Envio de Pago",
                "Se envia el pago a.....");
 
        this.as.guardarAuditoria("Auditoria");
 
        long fin = System.nanoTime();
        System.out.println("Tiempo de demora: " + ((fin - inicio) / 1_000_000.0) + " ms");
 
        return "Se realizó con éxito. Su saldo destino es: "
                + saldoDestino
                + " y su saldo origen es: "
                + saldoOrigen;
    }
 
    // Promesas en responder en 2 segundos
 
    public String realizarTransferenciaReactiva(String cuentaOrigen,
            String cuentaDestino,
            BigDecimal monto) throws InterruptedException {
 
        System.out.println("ID: " + Thread.currentThread().getName());
 
        long inicio = System.currentTimeMillis();
 
        Uni<BigDecimal> saldoDestino = this.cbs.agregaMontoPromesa(cuentaDestino, monto);
        Uni<BigDecimal> saldoOrigen = this.cbs.restaMontoPromesa(cuentaOrigen, monto);
 
        this.ms.enviarMail(
                "psaguasl@uce.edu.ec",
                "Envio de Pago",
                "Se envia el pago a.....");
        this.as.guardarAuditoria("Auditoria");
 
        String mensajefinal;
 
        long fin = System.currentTimeMillis();
 
        String mensajeFinal = Uni.combine().all().unis(saldoDestino, saldoOrigen).asTuple().map(resultado -> {
 
                    String mensaje = "Se realizó con éxito. Su saldo destino es: "
                            + resultado.getItem1()
                            + " y su saldo origen es: "
                            + resultado.getItem2();
 
                    // Tiene los datos como promesa de los saldo
                    resultado.getItem1();
                    resultado.getItem2();
                    return mensaje;
                }).toString();
 
 
        System.out.println("Tiempo de demora: " + (fin - inicio) + " ms");
 
        return mensajeFinal;
    }
 
}
 
