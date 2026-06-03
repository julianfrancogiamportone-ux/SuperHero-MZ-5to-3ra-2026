package jar.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jar.IService.IPeleadorService;
import jar.entidades.Peleador;
import jar.Repository.PeleadorRepository;

@Service
public class PeleadorService implements IPeleadorService {
@Autowired
private PeleadorRepository pRepository;
public List<Peleador> findAllPeleadores() {
return pRepository.findAll();
}
public Peleador savePeleador(Peleador peleador) {
return pRepository.save(peleador);
}
