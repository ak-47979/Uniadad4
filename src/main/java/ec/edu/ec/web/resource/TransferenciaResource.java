package ec.edu.ec.web.resource;

import java.math.BigDecimal;

import jakarta.ws.rs.Path;

@Path("/transferencia")
public class TransferenciaResource {

    private String cuentaOrigen;
    private String cuentaDestino;
    private BigDecimal monto;

    public String getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(String cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public String getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TransferenciaResource{");
        sb.append("cuentaOrigen=").append(cuentaOrigen);
        sb.append(", cuentaDestino=").append(cuentaDestino);
        sb.append(", monto=").append(monto);
        sb.append('}');
        return sb.toString();
    }


}
