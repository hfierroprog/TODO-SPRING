package cl.hfierroprog.tareasRest.tareasRest.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tarea")
public class Tarea implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String texto;

    @Column
    private String estado;

    public Tarea() {
    }

    public Tarea(String texto, String estado) {
        this.texto = texto;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", texto='" + texto + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
