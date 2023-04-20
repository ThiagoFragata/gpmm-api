package reserva_api.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reserva_api.model.Solicitacao;
import reserva_api.model.Viagem;
import reserva_api.repositories.MotoristaRepository;
import reserva_api.repositories.PessoaRepository;
import reserva_api.repositories.SolicitacaoRepository;
import reserva_api.repositories.TransporteRepository;
import reserva_api.repositories.ViagemRepository;

@Service
public class ViagemService {

	@Autowired
	private ViagemRepository viagemRepository;
	@Autowired
	private MotoristaRepository motoristaRepository;
	@Autowired
	private SolicitacaoRepository solicitacaoRepository;
	@Autowired
	private TransporteRepository transporteRepository;
	@Autowired
	private PessoaRepository pessoaRepository;

	public List<Viagem> buscarTodas() {
		return viagemRepository.findAll();
	}

	public Viagem buscarPorId(Long id) {
		return viagemRepository.findById(id).orElseThrow();
	}

	public List<Viagem> buscarPorSolicitacao(Long id) {
		Solicitacao solicitacao = solicitacaoRepository.findById(id).orElseThrow();
		return viagemRepository.findBySolicitacao(solicitacao).orElseThrow();
	}

	public Viagem salvar(Viagem viagem) {
		validarViagem(viagem);
		return viagemRepository.save(viagem);
	}

	public void excluirPorId(Long id) {
		viagemRepository.deleteById(id);
	}

	public Viagem atualizar(Long id, Viagem viagem) {
		validarViagem(viagem);
		Viagem viagemSalva = viagemRepository.findById(id).orElseThrow();
		BeanUtils.copyProperties(viagem, viagemSalva, "id");
		return viagemRepository.save(viagemSalva);
	}

	private void validarViagem(Viagem viagem) {
		motoristaRepository.findById(viagem.getMotorista().getId()).orElseThrow();
		solicitacaoRepository.findById(viagem.getSolicitacao().getId()).orElseThrow();
		transporteRepository.findById(viagem.getTransporte().getId()).orElseThrow();
		viagem.getPassageiros().stream().forEach(x -> pessoaRepository.findById(x.getId()).orElseThrow());

	}

}
