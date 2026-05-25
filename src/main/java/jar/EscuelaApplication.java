package jar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jar.entidades.Arma;
import jar.entidades.Ataque;
import jar.entidades.Peleador;
import java.util.List;
import java.util.ArrayList;

@SpringBootApplication
public class EscuelaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscuelaApplication.class, args);
	
	Peleador batman = new Peleador("batman", 500, 100, 250.05);
	Peleador superman = new Peleador("superman", 1000, 50, 500.05);
	Ataque Supergolpe = new Ataque(1,"Supergolpe", 200, 100);
	Ataque GolpeDeHielo = new Ataque(2,"Golpe de hielo", 5, 10);
	Ataque BolaDeFuego = new Ataque(3,"Bola de fuego", 20, 30);
	Ataque RayoLaser = new Ataque(4,"Rayo laser", 30, 20);
	Arma sol = new Arma(1,"sol", 200, 5.0f);
	Arma batarang = new Arma(2,"Batarang", 50, 0.5f);
	Arma lanza = new Arma(3,"Lanza", 100, 2.0f);
	Arma escudo = new Arma(4,"Escudo", 150, 3.0f);
	Arma martillo = new Arma(5,"Martillo", 120, 4.0f);
	Arma espada = new Arma(6,"Espada", 80, 1.5f);
	System.out.println(batman.getPuntosVida() + ", " + batman.getNombre());
	System.out.println(superman.getPuntosVida() + ", " + superman.getNombre());
 // Asignar armas a los peleadores (pto 3)
	List<Arma> armasB= new ArrayList<>();
	armasB.add(batarang);
	armasB.add(escudo);
	armasB.add(lanza);
	armasB.add(martillo);
	armasB.add(espada);
	batman.setArmas(armasB);

	List<Arma> armasS= new ArrayList<>();
	armasS.add(sol);
	superman.setArmas(armasS);

	List<Ataque> ataquesB= new ArrayList<>();
	ataquesB.add(Supergolpe);
	ataquesB.add(GolpeDeHielo);
	ataquesB.add(BolaDeFuego);
	batman.setAtaques(ataquesB);
// Asignar ataques a los peleadores (pto 4)
	List<Ataque> ataquesS= new ArrayList<>();
	ataquesS.add(RayoLaser);
	superman.setAtaques(ataquesS);




	System.out.println(batman.getArmas().get(0).getBonificadordanio());
	System.out.println(superman.getArmas().get(0).getBonificadordanio());

// Comparar el bonificador de daño de las armas (pto 2)
	 if (sol.getBonificadordanio() > batarang.getBonificadordanio()) {
        System.out.println(superman.getNombre() + " tiene el arma más fuerte: " + sol.getNombre());
    } else if (batarang.getBonificadordanio() > sol.getBonificadordanio()) {
        System.out.println(batman.getNombre() + " tiene el arma más fuerte: " + batarang.getNombre());
    } else {
        System.out.println("Ambos peleadores tienen armas igual de fuertes.");
    }
// Listar las armas de cada peleador (pto 3)	
    for (Arma a:  batman.getArmas()) {
		System.out.println("arma disponibles:" +a.getNombre());
	}



// Comparar el daño base de los ataques (pto 4)	
	for (Ataque at: batman.getAtaques()) {
		System.out.println("ataques disponibles:" +at.getNombre());
	}
	if (Supergolpe.getDanioBase() > GolpeDeHielo.getDanioBase() && Supergolpe.getDanioBase() > BolaDeFuego.getDanioBase()) {
        System.out.println(Supergolpe.getNombre() + " tiene el daño de base más alto: " + Supergolpe.getDanioBase());
    } else if (GolpeDeHielo.getDanioBase() > BolaDeFuego.getDanioBase()&& GolpeDeHielo.getDanioBase() > Supergolpe.getDanioBase()) {
        System.out.println(GolpeDeHielo.getNombre() + " tiene el daño de base más alto: " + GolpeDeHielo.getDanioBase());
    } else {
        System.out.println("Bola de fuego tiene el daño de base más alto: " + BolaDeFuego.getDanioBase());
    }


// Calcular el promedio de costo de energía de los ataques (pto 5)	
	float sum=0;
	float prom=0;
	for (Ataque at: batman.getAtaques()) {
		sum+=at.getCostoEnergia();
	}
	prom= sum/batman.getAtaques().size();
	if (prom>50){
		System.out.println("¡cuidado el promedio es mayor  50!: " + prom);
	} else {
		System.out.println("el promedio es menor a 50, en total el promedio es: " + prom);
	}
	


// Verificar si un peleador tiene suficiente energía para realizar un ataque (pto 7)
	if (batman.getEnergia()>=Supergolpe.getCostoEnergia()) {
		System.out.println(batman.getNombre() + " puede realizar el ataque: " + Supergolpe.getNombre());
	} else {
		System.out.println(batman.getNombre() + " esta demasiado cansado para realizar el ataque: " + Supergolpe.getNombre());
	}


	
	calcularDaño(batman, superman, Supergolpe);
	recuperacion(superman, superman.getPuntosVida(), superman.getEnergia());
	
// Filtrado de habilidades (punto 9)	
	for (Ataque at: batman.getAtaques()) {
		sum+=at.getCostoEnergia();
		System.out.println("ataques disponibles:" +at.getNombre());
	if (batman.getEnergia()>=at.getCostoEnergia()) {
		System.out.println(batman.getNombre() + " puede realizar el ataque: " + at.getNombre());
	} else {
		System.out.println(batman.getNombre() + " esta demasiado cansado para realizar el ataque: " + at.getNombre());
	}
}


// Simulación de una pelea entre dos peleadores (pto 10)
while (batman.getPuntosVida() > 0 && superman.getPuntosVida() > 0) {

superman.setPuntosVida(superman.getPuntosVida() - batman.getAtaques().get(0).getDanioBase());
batman.setPuntosVida(batman.getPuntosVida() - superman.getAtaques().get(0).getDanioBase());
System.out.println("La pelea continúa... Puntos de vida de " + batman.getNombre() + ": " + batman.getPuntosVida() + ", Puntos de vida de " + superman.getNombre() + ": " + superman.getPuntosVida());

}

if (batman.getPuntosVida() <= 0 && superman.getPuntosVida() <= 0) {
	System.out.println("¡Es un empate!");
} else if (batman.getPuntosVida() <= 0) {
	System.out.println(superman.getNombre() + " ha ganado la pelea!");
} else {
	System.out.println(batman.getNombre() + " ha ganado la pelea!");
}
	
}


// 	
	public static void calcularDaño(Peleador atacante, Peleador defensor, Ataque ataque) {
		int danioTotal = ataque.getDanioBase() + atacante.getArmas().get(0).getBonificadordanio();
		defensor.setPuntosVida(defensor.getPuntosVida() - danioTotal);
		System.out.println("A " +defensor.getNombre() + " le queda " + defensor.getPuntosVida() + " puntos de vida.");
		
	}


// Descanso tactico (punto 8)
	public static void recuperacion(Peleador peleador, int puntosVida, int energia){
		if (puntosVida<= 200 ){
			puntosVida+= 500;
			energia = 0; 
			System.out.println(peleador.getNombre() + " Ha tenido una recuperación pesada. Puntos de vida: " + puntosVida + ", Energía: " + energia);
		} else {
			energia+=100;}
		System.out.println(peleador.getNombre() + " Ha tenido un descanso rápido. Puntos de vida: " + puntosVida + ", Energía: " + energia);
		}

		


}

