package reserva_api.repositories.solicitacao;

import java.util.List;

import reserva_api.dto.ReservaDto;
import reserva_api.repositories.filters.RecursoFilter;

public interface SolicitacaoRepositoryQuery {
	public List<ReservaDto> todasReservaPorData(RecursoFilter recursoFilter);
	public List<ReservaDto> reservaLocalPorData(RecursoFilter recursoFilter);
	public List<ReservaDto> reservaEquipamentoPorData(RecursoFilter recursoFilter);
	public List<ReservaDto> reservaTransportePorData(RecursoFilter recursoFilter);

}
