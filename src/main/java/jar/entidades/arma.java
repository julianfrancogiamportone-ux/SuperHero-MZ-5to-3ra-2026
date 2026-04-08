package jar.entidades;
import jakarta.persistence.*;
@Entity
public class arma {
    private long id;
    private String nombre;
    private int bonificadordanio;
    private float peso;
    public arma(long id, String nombre, int bonificadordanio, float peso) {
        this.id = id;
        this.nombre = nombre;
        this.bonificadordanio = bonificadordanio;
        this.peso = peso;
        
    }
    public long getId() {
        return id;
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


    public void setId(long id) {
        this.id = id;
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
