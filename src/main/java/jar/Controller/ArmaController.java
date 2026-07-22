package jar.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jar.IService.IArmaService;
import jar.entidades.Arma;

@RestController
@RequestMapping("/api/characters")
public class ArmaController {
@Autowired
private IArmaService pService;
@GetMapping
public List<Arma> getAllArmas() {
return pService.findAllArmas();
}
@PostMapping
public Arma createArma(@RequestBody Arma arma) {
return pService.saveArma(arma);
}
}