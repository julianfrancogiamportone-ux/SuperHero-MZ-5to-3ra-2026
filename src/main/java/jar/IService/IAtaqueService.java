package jar.IService;
import java.util.List;
import jar.entidades.Ataque;

public interface IAtaqueService {
public List<Ataque> findAllAtaques();
public Ataque saveAtaque(Ataque ataque);
}