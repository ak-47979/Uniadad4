package ec.edu.ec.application.service;

import java.math.BigDecimal;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CuentaBancariaService {
    public BigDecimal agregaMonto(String numCuenta, BigDecimal monto) {
    long inicio = System.nanoTime();

    Thread hilo = Thread.currentThread();

    System.out.println("Hilo: " + hilo.getName() +
            " | ID: " + hilo.threadId());

    try {
        Thread.sleep(1000); // Espera de 1000 milisegundos
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println("El hilo fue interrumpido");
    }

    BigDecimal saldo = BigDecimal.valueOf(1000);
    saldo = saldo.add(monto);

    long tiempoMs = (System.nanoTime() - inicio) / 1_000_000;

    System.out.println("Cuenta: " + numCuenta +
            " | Hilo: " + hilo.getName() +
            " | ID: " + hilo.threadId() +
            " | Tiempo ejecución: " + tiempoMs + " ms");

    return saldo;
}

   public BigDecimal restaMonto(String numCuenta, BigDecimal monto) {
    long inicio = System.nanoTime();

    Thread hilo = Thread.currentThread();

    System.out.println("Hilo: " + hilo.getName() +
            " | ID: " + hilo.threadId());

    try {
        Thread.sleep(2000); // Espera de 2000 milisegundos
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println("El hilo fue interrumpido");
    }

    BigDecimal saldo = BigDecimal.valueOf(2000);
    saldo = saldo.subtract(monto);

    long tiempoMs = (System.nanoTime() - inicio) / 1_000_000;

    System.out.println("Cuenta: " + numCuenta +
            " | Hilo: " + hilo.getName() +
            " | ID: " + hilo.threadId() +
            " | Tiempo ejecución: " + tiempoMs + " ms");

    return saldo;
}

  public Uni<BigDecimal> agregaMontoPromesa(String numCuenta, BigDecimal monto) {
   return Uni.createFrom().item(this.agregaMonto(numCuenta, monto));
}

   public Uni<BigDecimal> restaMontoPromesa(String numCuenta, BigDecimal monto) {
    return Uni.createFrom().item(()->{
        //todo lo que me demora en ejecutar
        return this.restaMonto(numCuenta, monto);
    });
}

}
