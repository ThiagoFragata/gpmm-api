package reserva_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import reserva_api.dto.PessoaDto;
import reserva_api.model.Motorista;
import reserva_api.model.Pessoa;
import reserva_api.repositories.MotoristaRepository;
import reserva_api.repositories.PessoaRepository;
import reserva_api.repositories.filters.PessoaFilter;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private MotoristaRepository motoristaRepository;

	public Page<Pessoa> buscarTodos(Pageable pageable) {
		return pessoaRepository.findAll(pageable);
	}
	
	public Page<PessoaDto> filtarTodas(PessoaFilter pessoaFilter,Pageable pageable) {
		return pessoaRepository.filtrarPessoa(pessoaFilter, pageable);
	}

	public Pessoa buscarPorId(Long id) {
		return pessoaRepository.findById(id).orElseThrow();
	}

	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	public Pessoa salvar(Motorista motorista) {
		return pessoaRepository.save(motorista);
	}

	public void excluirPorId(Long id) {
		pessoaRepository.deleteById(id);
	}

	public Pessoa atualizar(Long id, Pessoa pessoa) {
		Pessoa pessoaSalvo = pessoaRepository.getReferenceById(id);
		copyPessoa(pessoa, pessoaSalvo);
		return pessoaRepository.save(pessoaSalvo);
	}

	public Pessoa atualizar(Long id, Motorista motorista) {
		Motorista pessoaSalvo = motoristaRepository.getReferenceById(id);
		copyMotorista(motorista, pessoaSalvo);
		return pessoaRepository.save(pessoaSalvo);
	}

	private void copyPessoa(Pessoa pessoa, Pessoa pessoaSalvo) {
		if (pessoa.getNome() != null) {
			pessoaSalvo.setNome(pessoa.getNome());
		}
		if (pessoa.getCpf() != null) {
			pessoaSalvo.setCpf(pessoa.getCpf());
		}
		if (pessoa.getSetor() != null) {
			pessoaSalvo.setSetor(pessoa.getSetor());
		}
		if (pessoa.getSiape() != null) {
			pessoaSalvo.setSiape(pessoa.getSiape());

		}
		if (pessoa.getDataNascimento() != null) {
			pessoaSalvo.setDataNascimento(pessoa.getDataNascimento());
		}

	}

	private void copyMotorista(Motorista pessoa, Motorista pessoaSalvo) {
		if (pessoa.getNome() != null) {
			pessoaSalvo.setNome(pessoa.getNome());
		}
		if (pessoa.getCpf() != null) {
			pessoaSalvo.setCpf(pessoa.getCpf());
		}
		if (pessoa.getSetor() != null) {
			pessoaSalvo.setSetor(pessoa.getSetor());
		}
		if (pessoa.getSiape() != null) {
			pessoaSalvo.setSiape(pessoa.getSiape());

		}
		if (pessoa.getDataNascimento() != null) {
			pessoaSalvo.setDataNascimento(pessoa.getDataNascimento());
		}
		if (pessoa.getNumeroCnh() != null) {
			pessoaSalvo.setNumeroCnh(pessoa.getNumeroCnh());

		}

	}

}
