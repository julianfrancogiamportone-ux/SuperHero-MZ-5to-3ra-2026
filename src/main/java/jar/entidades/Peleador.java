package jar.entidades;

import java.util.ArrayList;

import jakarta.persistence.*;
import java.util.List;

@Entity

public class Peleador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    @JoinTable(name = "peleador_arma", joinColumns = @JoinColumn(name = "peleador_id"), inverseJoinColumns = @JoinColumn(name = "arma_id"))

    private List<Arma> armas;
   
    @ManyToMany
    @JoinTable(name = "peleador_ataque", joinColumns = @JoinColumn(name = "peleador_id"), inverseJoinColumns = @JoinColumn(name = "ataque_id"))

    private List<Ataque> ataques;
    private String nombre;
    private int puntosVida;
    private int energia;
    private double defensaBase;
  

    public Peleador( String nombre, int puntosVida, int energia, double defensaBase)
    {
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

    public double getDefensaBase() {
        return defensaBase;
    }
    
    public List<Arma> getArmas() {
        return armas;
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

    public void setArmas(List<Arma> armas) {
        this.armas = armas;
    }

    
    public List<Ataque> getAtaques() {
        return ataques;
    }



    public void setAtaques(List<Ataque> ataques) {
        this.ataques = ataques;
    }



    public void setDefensaBase(double defensaBase) {
        this.defensaBase = defensaBase;
    }



    public void imprimir(){
        System.out.println("Peleador: " + nombre);
        System.out.println("Puntos de Vida: " + puntosVida);
        System.out.println("Energía: " + energia);
        System.out.println("Defensa Base: " + defensaBase);
        System.out.println("Armas:" + armas);
        
    }
 
    
}