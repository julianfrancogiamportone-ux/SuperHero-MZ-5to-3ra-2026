package jar.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jar.IService.IAtaqueService;
import jar.entidades.Ataque;

@RestController
@RequestMapping("/api/Ataque")
public class AtaqueController {
@Autowired
private IAtaqueService pService;
@GetMapping
public List<Ataque> getAllAtaques() {
return pService.findAllAtaques();
}
@PostMapping
public Ataque createAtaque(@RequestBody Ataque ataque) {
return pService.saveAtaque(ataque);
}
}