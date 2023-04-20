package reserva_api.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import reserva_api.model.Setor;
import reserva_api.services.SetorService;

@RestController
@RequestMapping(value = "/setores")
public class SetorResource {
	
	@Autowired
	private SetorService setorService;
	
	@GetMapping
	public ResponseEntity<List<Setor>> buscarTodos() {
		return ResponseEntity.ok().body(setorService.buscarTodos());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Setor> buscarPorId(@PathVariable Long id) {
		Setor setor = setorService.buscarPorId(id);
		return ResponseEntity.ok().body(setor);
	}
	
	@PostMapping
	public ResponseEntity<Setor> salvar(@Valid @RequestBody Setor setor) {
		Setor setorSalvo = setorService.salvar(setor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(setorSalvo.getId()).toUri();
		return ResponseEntity.created(uri).body(setorSalvo);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluirPorId(@PathVariable Long id) {
		setorService.excluirPorId(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Setor> atualizar(@PathVariable Long id, @Valid @RequestBody Setor setor) {
		Setor setorSalvo = setorService.atualizar(id, setor);
		return ResponseEntity.ok(setorSalvo);
	}
	
	
	
	

}
