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
import reserva_api.model.Motorista;
import reserva_api.model.Pessoa;
import reserva_api.services.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping
	public ResponseEntity<List<Pessoa>> buscarTodos() {
		return ResponseEntity.ok().body(pessoaService.buscarTodos());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pessoa> buscarPorId(@PathVariable Long id) {
		Pessoa pessoa = pessoaService.buscarPorId(id);
		return ResponseEntity.ok().body(pessoa);
	}

	@PostMapping
	public ResponseEntity<Pessoa> salvar(@Valid @RequestBody Pessoa pessoa) {
		Pessoa pessoaSalvo = pessoaService.salvar(pessoa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoaSalvo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(pessoaSalvo);
	}

	@PostMapping(value = "/motoristas")
	public ResponseEntity<Pessoa> salvar(@Valid @RequestBody Motorista pessoa) {
		Pessoa pessoaSalvo = pessoaService.salvar(pessoa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoaSalvo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(pessoaSalvo);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluirPorId(@PathVariable Long id) {
		pessoaService.excluirPorId(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @Valid @RequestBody Pessoa pessoa) {
		Pessoa pessoaSalvo = pessoaService.atualizar(id, pessoa);
		return ResponseEntity.ok(pessoaSalvo);
	}

	@PutMapping("/motoristas/{id}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @Valid @RequestBody Motorista pessoa) {
		Pessoa pessoaSalvo = pessoaService.atualizar(id, (Motorista) pessoa);
		return ResponseEntity.ok(pessoaSalvo);
	}

}
