package jar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jar.entidades.Arma;
public interface Repository extends JpaRepository<Arma, Long> {
}

