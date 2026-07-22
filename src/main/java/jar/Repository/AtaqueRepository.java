package jar.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import jar.entidades.Ataque;

public interface AtaqueRepository extends JpaRepository<Ataque, Long> {
}