package jar.IService;
import java.util.List;
import jar.entidades.Peleador;

public interface IPeleadorService {
public List<Peleador> findAllPeleadores();
public Peleador savePeleador(Peleador peleador);
}
