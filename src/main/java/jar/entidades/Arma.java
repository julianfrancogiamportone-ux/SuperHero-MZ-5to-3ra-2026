package jar.entidades;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Arma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "armas")
    @JsonIgnore // <- Arma no necesita devolver la lista de peleadores al frontend
    
    private List<Peleador> personajes;
    private String nombre;
    private int bonificadordanio;
    private float peso;
    
    public Arma() {
    }


    public Arma(long id, String nombre, int bonificadordanio, float peso) {
        this.id = id;
        this.nombre = nombre;
        this.bonificadordanio = bonificadordanio;
        this.peso = peso;

    }

  

    public String getNombre() {
        return nombre;
    }

    public int getBonificadordanio() {
        return bonificadordanio;
    }

    public float getPeso() {
        return peso;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setBonificadordanio(int bonificadordanio) {
        this.bonificadordanio = bonificadordanio;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

}
