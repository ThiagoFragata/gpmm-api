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
import reserva_api.model.Equipamento;
import reserva_api.model.Local;
import reserva_api.model.Motorista;
import reserva_api.model.Pessoa;
import reserva_api.model.Recurso;
import reserva_api.model.Transporte;
import reserva_api.services.RecursoService;

@RestController
@RequestMapping(value = "/recursos")
public class RecursoResource {

	@Autowired
	private RecursoService recursoService;

	@GetMapping
	public ResponseEntity<List<Recurso>> buscarTodos() {
		return ResponseEntity.ok().body(recursoService.buscarTodos());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Recurso> buscarPorId(@PathVariable Long id) {
		Recurso recurso = recursoService.buscarPorId(id);
		return ResponseEntity.ok().body(recurso);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluirPorId(@PathVariable Long id) {
		recursoService.excluirPorId(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/transportes")
	public ResponseEntity<List<Transporte>> buscarTransportes() {
		return ResponseEntity.ok().body(recursoService.buscarTransportes());
	}

	@PostMapping(value = "/transportes")
	public ResponseEntity<Recurso> salvar(@Valid @RequestBody Transporte transporte) {
		Recurso recursoSalvo = recursoService.salvar(transporte);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(recursoSalvo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(recursoSalvo);
	}

	@PutMapping("/transportes/{id}")
	public ResponseEntity<Recurso> atualizar(@PathVariable Long id, @Valid @RequestBody Transporte transporte) {
		Recurso recursoSalvo = recursoService.atualizar(id, transporte);
		return ResponseEntity.ok(recursoSalvo);
	}

	@GetMapping(value = "/locais")
	public ResponseEntity<List<Local>> buscarLocais() {
		return ResponseEntity.ok().body(recursoService.buscarLocais());
	}

	@PostMapping(value = "/locais")
	public ResponseEntity<Recurso> salvar(@Valid @RequestBody Local local) {
		Recurso recursoSalvo = recursoService.salvar(local);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(recursoSalvo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(recursoSalvo);
	}

	@PutMapping("/locais/{id}")
	public ResponseEntity<Recurso> atualizar(@PathVariable Long id, @Valid @RequestBody Local local) {
		Recurso recursoSalvo = recursoService.atualizar(id, local);
		return ResponseEntity.ok(recursoSalvo);
	}

	@GetMapping(value = "/equipamentos")
	public ResponseEntity<List<Equipamento>> buscarEquipamentos() {
		return ResponseEntity.ok().body(recursoService.buscarEquipamentos());
	}

	@PostMapping(value = "/equipamentos")
	public ResponseEntity<Recurso> salvar(@Valid @RequestBody Equipamento equipamento) {
		Recurso recursoSalvo = recursoService.salvar(equipamento);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(recursoSalvo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(recursoSalvo);
	}

	@PutMapping("/equipamentos/{id}")
	public ResponseEntity<Recurso> atualizar(@PathVariable Long id, @Valid @RequestBody Equipamento equipamento) {
		Recurso recursoSalvo = recursoService.atualizar(id, equipamento);
		return ResponseEntity.ok(recursoSalvo);
	}

}
