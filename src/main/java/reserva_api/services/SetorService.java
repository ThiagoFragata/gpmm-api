package reserva_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import reserva_api.model.Setor;
import reserva_api.repositories.SetorRepository;

@Service
public class SetorService {

	@Autowired
	private SetorRepository setorRepository;

	public Page<Setor> buscarTodos(Pageable pageable) {
		return setorRepository.findAll(pageable);
	}

	public Setor buscarPorId(Long id) {
		return setorRepository.findById(id).orElseThrow();
	}

	public Setor salvar(Setor setor) {
		return setorRepository.save(setor);
	}

	public void excluirPorId(Long id) {
		setorRepository.deleteById(id);
	}

	public Setor atualizar(Long id, Setor setor) {
		Setor setorSalvo = setorRepository.getReferenceById(id);
		copySetor(setor, setorSalvo);
		return setorRepository.save(setorSalvo);
	}

	private void copySetor(Setor setor, Setor setorSalvo) {
		setorSalvo.setNome(setor.getNome());
	}

}
