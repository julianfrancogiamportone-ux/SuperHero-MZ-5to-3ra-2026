package jar.entidades;


import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity

public class Peleador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    @JoinTable(name = "peleador_arma", joinColumns = @JoinColumn(name = "peleador_id"), inverseJoinColumns = @JoinColumn(name = "arma_id"))
    @JsonIgnoreProperties("personajes") // <- corta el loop del lado de Arma
    private List<Arma> armas;

    @ManyToMany
    @JoinTable(name = "peleador_ataque", joinColumns = @JoinColumn(name = "peleador_id"), inverseJoinColumns = @JoinColumn(name = "ataque_id"))
    @JsonIgnoreProperties("personajes")// <- corta el loop del lado de Ataque
   
    private List<Ataque> ataques;
    private String nombre;
    private int puntosVida;
    private int energia;
    private double defensaBase;
    private String url;

    public Peleador() {
    }

    public Peleador(String nombre, int puntosVida, int energia, double defensaBase, String url)
    {
        
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.energia = energia;
        this.defensaBase = defensaBase;
        this.url = url;
    }

   //Getters____________________________________________________

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

    public String getUrl() {
        return url;
    }

    public List<Arma> getArmas() {
        return armas;
    }

    public List<Ataque> getAtaques() {
        return ataques;
    }

    //Setters____________________________________________________

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public void setDefensaBase(double defensaBase) {
        this.defensaBase = defensaBase;
    }
     public void setArmas(List<Arma> armas) {
        this.armas = armas;
    }

    public void setAtaques(List<Ataque> ataques) {
        this.ataques = ataques;
    }

    public void imprimir() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Puntos de Vida: " + puntosVida);
        System.out.println("Energía: " + energia);
        System.out.println("Defensa Base: " + defensaBase);
        System.out.println("URL: " + url);
    }
}
