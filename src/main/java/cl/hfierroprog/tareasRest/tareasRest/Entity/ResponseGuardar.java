package cl.hfierroprog.tareasRest.tareasRest.Entity;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class ResponseGuardar implements Serializable {

    private HttpStatus codigo;
    private String mensaje;
    private Tarea tarea;

    public ResponseGuardar() {
    }

    public ResponseGuardar(HttpStatus codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public HttpStatus getCodigo() {
        return codigo;
    }

    public void setCodigo(HttpStatus codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    @Override
    public String toString() {
        return "ResponseGuardar{" +
                "codigo=" + codigo +
                ", mensaje='" + mensaje + '\'' +
                ", tarea=" + tarea +
                '}';
    }
}
