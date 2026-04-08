package jar.entidades;
import jakarta.persistence.*;
@Entity
public class ataque {
private long id;
private String nombre;
private int costoEnergia;
private int danioBase;
public ataque(long id, String nombre, int costoEnergia, int danioBase) {
    this.id = id;
    this.nombre = nombre;
    this.costoEnergia = costoEnergia;
    this.danioBase = danioBase;
}
public long getId() {
    return id;
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
public void setId(long id) {
    this.id = id;
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
