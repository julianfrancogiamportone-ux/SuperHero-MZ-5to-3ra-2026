package jar.entidades;

import java.util.ArrayList;

import jakarta.persistence.*;
import java.util.List;

@Entity

public class peleador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    @JoinTable(name = "peleador_arma", joinColumns = @JoinColumn(name = "peleador_id"), inverseJoinColumns = @JoinColumn(name = "arma_id"))

    private List<arma> armas;
    @ManyToMany
    @JoinTable(name = "peleador_ataque", joinColumns = @JoinColumn(name = "peleador_id"), inverseJoinColumns = @JoinColumn(name = "ataque_id"))

    private List<ataque> ataque;
    private String nombre;
    private int puntosVida;
    private int energia;
    private float defensaBase;
  

    public peleador(long id, String nombre, int puntosVida, int energia, float defensaBase, arma armaEquipada,
            ArrayList<arma> inventario, ArrayList<ataque> habilidades) {
        this.id = id;
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.energia = energia;
        this.defensaBase = defensaBase;
        
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public int getEnergia() {
        return energia;
    }

    public float getDefensaBase() {
        return defensaBase;
    }

   
    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public void setDefensaBase(float defensaBase) {
        this.defensaBase = defensaBase;
    }

    
}
