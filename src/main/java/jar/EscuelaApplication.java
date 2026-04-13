package jar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jar.entidades.peleador;

@SpringBootApplication
public class EscuelaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscuelaApplication.class, args);
		peleador p1 = new peleador(1,"Goku",100,100,0.2f,null,null,null);
		System.out.println();
	}

}
