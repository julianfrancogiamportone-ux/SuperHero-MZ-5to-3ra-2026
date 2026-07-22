package jar.IService;
import java.util.List;
import jar.entidades.Arma;

public interface IArmaService {
public List<Arma> findAllArmas();
public Arma saveArma(Arma arma);
}
