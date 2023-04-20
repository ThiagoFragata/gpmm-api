package reserva_api.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reserva_api.model.Equipamento;
import reserva_api.model.Local;
import reserva_api.model.Recurso;
import reserva_api.model.Transporte;
import reserva_api.repositories.EquipamentoRepository;
import reserva_api.repositories.LocalRepository;
import reserva_api.repositories.RecursoRepository;
import reserva_api.repositories.TransporteRepository;

@Service
public class RecursoService {

	@Autowired
	private RecursoRepository recursoRepository;

	@Autowired
	private TransporteRepository transporteRepository;

	@Autowired
	private LocalRepository localRepository;

	@Autowired
	private EquipamentoRepository equipamentoRepository;

	public List<Recurso> buscarTodos() {
		return recursoRepository.findAll();
	}

	public Recurso buscarPorId(Long id) {
		return recursoRepository.findById(id).orElseThrow();
	}

	public void excluirPorId(Long id) {
		recursoRepository.deleteById(id);
	}

	public List<Transporte> buscarTransportes() {
		return transporteRepository.findAll();
	}

	public Transporte salvar(Transporte transporte) {
		return transporteRepository.save(transporte);
	}

	public Transporte atualizar(Long id, Transporte transporte) {
		Transporte transporteSalvo = transporteRepository.findById(id).orElseThrow();
		BeanUtils.copyProperties(transporte, transporteSalvo, "id");
		return transporteRepository.save(transporteSalvo);
	}

	public List<Local> buscarLocais() {
		return localRepository.findAll();
	}
	
	public Local salvar(Local local) {
		return localRepository.save(local);
	}

	public Local atualizar(Long id, Local local) {
		Local localSalvo = localRepository.findById(id).orElseThrow();
		BeanUtils.copyProperties(local, localSalvo, "id");
		return localRepository.save(localSalvo);
	}

	public List<Equipamento> buscarEquipamentos() {
		return equipamentoRepository.findAll();
	}
	
	public Equipamento salvar(Equipamento equipamento) {
		return equipamentoRepository.save(equipamento);
	}

	public Equipamento atualizar(Long id, Equipamento equipamento) {
		Equipamento equipamentoSalvo = equipamentoRepository.findById(id).orElseThrow();
		BeanUtils.copyProperties(equipamento, equipamentoSalvo, "id");
		return equipamentoRepository.save(equipamentoSalvo);
	}

}
