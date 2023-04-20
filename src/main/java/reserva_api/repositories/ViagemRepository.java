package reserva_api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import reserva_api.model.Pessoa;
import reserva_api.model.Solicitacao;
import reserva_api.model.Viagem;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long>  {
	public Optional<List<Viagem>> findBySolicitacao(Solicitacao solicitacao);

}
