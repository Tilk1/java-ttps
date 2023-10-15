package modelo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "MENSAJES")
public class Mensaje implements Serializable {
    @Id @GeneratedValue
    @Column(name="MENSAJE_ID")
    private Long id;
    public String texto;
    private Date dia;

    public Mensaje() {
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setDia(Date date) {
        this.dia = date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}