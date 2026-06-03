package jar.IService;
import java.util.List;
import com.NinjaWorld.Naruto.model.Personage;
public interface IPersonageService {
public List<Personage> findAllCharacters();
public Personage saveCharacter(Personage personage);
}
public interface IPeleadorService {
public List<Peleador> findAllPeleadores();
public Peleador savePeleador(Peleador peleador);
}
