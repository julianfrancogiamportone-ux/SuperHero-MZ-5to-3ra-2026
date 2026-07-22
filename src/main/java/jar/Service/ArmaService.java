package jar.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jar.IService.IArmaService;
import jar.entidades.Arma;
import jar.Repository.ArmaRepository;

@Service
public class ArmaService implements IArmaService {
@Autowired
private ArmaRepository aRepository;
public List<Arma> findAllArmas() {
return aRepository.findAll();
}
public Arma saveArma(Arma arma) {
return aRepository.save(arma);
}
}   