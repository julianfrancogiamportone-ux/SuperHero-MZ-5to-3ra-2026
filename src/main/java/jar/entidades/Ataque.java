package jar.entidades;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Ataque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToMany(mappedBy = "ataques")
    private List<Peleador> personajes;
    private String nombre;
    private int costoEnergia;
    private int danioBase;

    public Ataque(long id, String nombre, int costoEnergia, int danioBase) {
        this.id = id;
        this.nombre = nombre;
        this.costoEnergia = costoEnergia;
        this.danioBase = danioBase;
    }

   
    public String getNombre() {
        return nombre;
    }

    public int getCostoEnergia() {
        return costoEnergia;
    }

    public int getDanioBase() {
        return danioBase;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCostoEnergia(int costoEnergia) {
        this.costoEnergia = costoEnergia;
    }

    public void setDanioBase(int danioBase) {
        this.danioBase = danioBase;
    }
}
