package jar.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jar.IService.IAtaqueService;
import jar.entidades.Ataque;
import jar.Repository.AtaqueRepository;

@Service
public class AtaqueService implements IAtaqueService {
@Autowired
private AtaqueRepository pRepository;
public List<Ataque> findAllAtaques() {
return pRepository.findAll();
}
public Ataque saveAtaque(Ataque ataque) {
return pRepository.save(ataque);
}
}