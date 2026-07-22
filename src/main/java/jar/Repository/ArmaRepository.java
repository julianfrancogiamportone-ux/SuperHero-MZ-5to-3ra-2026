package jar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jar.entidades.Arma;

public interface ArmaRepository extends JpaRepository<Arma, Long> {
}