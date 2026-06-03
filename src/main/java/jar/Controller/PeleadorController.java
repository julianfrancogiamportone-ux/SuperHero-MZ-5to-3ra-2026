package jar.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jar.IService.IPeleadorService;
import jar.entidades.Peleador;

@RestController
@RequestMapping("/api/characters")
public class PeleadorController {
@Autowired
private IPeleadorService pService;
@GetMapping
public List<Peleador> getAllPeleadores() {
return pService.findAllPeleadores();
}
@PostMapping
public Peleador createPeleador(@RequestBody Peleador peleador) {
return pService.savePeleador(peleador);
}
}