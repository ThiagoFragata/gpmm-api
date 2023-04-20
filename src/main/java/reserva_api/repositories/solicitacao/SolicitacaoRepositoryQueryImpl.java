package reserva_api.repositories.solicitacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.ObjectUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import reserva_api.dto.ReservaDto;
import reserva_api.model.Equipamento;
import reserva_api.model.Local;
import reserva_api.model.Pessoa;
import reserva_api.model.Recurso;
import reserva_api.model.Solicitacao;
import reserva_api.model.Transporte;
import reserva_api.repositories.filters.RecursoFilter;

public class SolicitacaoRepositoryQueryImpl implements SolicitacaoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<ReservaDto> todasReservaPorData(RecursoFilter recursoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ReservaDto> criteria = builder.createQuery(ReservaDto.class);
		Root<Solicitacao> root = criteria.from(Solicitacao.class);
		Join<Solicitacao, Recurso> recursoJoin = root.join("recursos");
		Join<Solicitacao, Pessoa> pessoaJoin = root.join("solicitante");
		
		
		List<Predicate> predicate = new ArrayList<Predicate>();
		if(!ObjectUtils.isEmpty(recursoFilter.getDataInicio()) || !ObjectUtils.isEmpty(recursoFilter.getDataFinal())) {
			predicate.add(
					builder.greaterThan(root.get("dataFinal"), recursoFilter.getDataInicio()));
			predicate.add(
					builder.lessThan(root.get("dataInicio"), recursoFilter.getDataFinal()));
		}
		if(!ObjectUtils.isEmpty(recursoFilter.getIdRecurso())) {
			predicate.add(builder.equal(recursoJoin.get("id"), recursoFilter.getIdRecurso()));			
		}
		criteria.orderBy(builder.asc(root.get("dataInicio")));
		criteria.distinct(true);

		criteria.select(builder.construct(ReservaDto.class, root.get("id"), recursoJoin.get("id"),
				recursoJoin.get("descricao"), root.get("dataInicio"), root.get("dataFinal"),
				pessoaJoin.get("nome"),pessoaJoin.get("telefone").get("numero"),root.get("status")
				));

		criteria.where(builder.and(predicate.toArray(new Predicate[predicate.size()])));

		List<ReservaDto> returnList = manager.createQuery(criteria).getResultList();

		return returnList;
	}

	@Override
	public List<ReservaDto> reservaLocalPorData(RecursoFilter recursoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ReservaDto> criteria = builder.createQuery(ReservaDto.class);
		Root<Solicitacao> root = criteria.from(Solicitacao.class);
		Join<Solicitacao, Recurso> recursoJoin = root.join("recursos");
		Join<Solicitacao, Pessoa> pessoaJoin = root.join("solicitante");
		
		List<Predicate> predicate = new ArrayList<Predicate>();
		if(!ObjectUtils.isEmpty(recursoFilter.getDataInicio()) || !ObjectUtils.isEmpty(recursoFilter.getDataFinal())) {
			predicate.add(
					builder.greaterThan(root.get("dataFinal"), recursoFilter.getDataInicio()));
			predicate.add(
					builder.lessThan(root.get("dataInicio"), recursoFilter.getDataFinal()));
		}
		if(!ObjectUtils.isEmpty(recursoFilter.getIdRecurso())) {
			predicate.add(builder.equal(recursoJoin.get("id"), recursoFilter.getIdRecurso()));			
		}
		predicate.add(builder.equal(recursoJoin.type(), Local.class));
		
		criteria.orderBy(builder.asc(root.get("dataInicio")));
		criteria.distinct(true);

		criteria.select(builder.construct(ReservaDto.class, root.get("id"), recursoJoin.get("id"),
				recursoJoin.get("descricao"), root.get("dataInicio"), root.get("dataFinal"),
				pessoaJoin.get("nome"),pessoaJoin.get("telefone").get("numero"),root.get("status")
				));

		criteria.where(builder.and(predicate.toArray(new Predicate[predicate.size()])));

		List<ReservaDto> returnList = manager.createQuery(criteria).getResultList();

		return returnList;

	}

	@Override
	public List<ReservaDto> reservaEquipamentoPorData(RecursoFilter recursoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ReservaDto> criteria = builder.createQuery(ReservaDto.class);
		Root<Solicitacao> root = criteria.from(Solicitacao.class);
		Join<Solicitacao, Recurso> recursoJoin = root.join("recursos");
		Join<Solicitacao, Pessoa> pessoaJoin = root.join("solicitante");

		List<Predicate> predicate = new ArrayList<Predicate>();
		if(!ObjectUtils.isEmpty(recursoFilter.getDataInicio()) || !ObjectUtils.isEmpty(recursoFilter.getDataFinal())) {
			predicate.add(
					builder.greaterThan(root.get("dataFinal"), recursoFilter.getDataInicio()));
			predicate.add(
					builder.lessThan(root.get("dataInicio"), recursoFilter.getDataFinal()));
		}
		if(!ObjectUtils.isEmpty(recursoFilter.getIdRecurso())) {
			predicate.add(builder.equal(recursoJoin.get("id"), recursoFilter.getIdRecurso()));			
		}
		predicate.add(builder.equal(recursoJoin.type(), Equipamento.class));

		criteria.orderBy(builder.asc(root.get("dataInicio")));
		criteria.distinct(true);

		criteria.select(builder.construct(ReservaDto.class, root.get("id"), recursoJoin.get("id"),
				recursoJoin.get("descricao"), root.get("dataInicio"), root.get("dataFinal"),
				pessoaJoin.get("nome"),pessoaJoin.get("telefone").get("numero"),root.get("status")
				));

		criteria.where(builder.and(predicate.toArray(new Predicate[predicate.size()])));

		List<ReservaDto> returnList = manager.createQuery(criteria).getResultList();

		return returnList;
	}

	@Override
	public List<ReservaDto> reservaTransportePorData(RecursoFilter recursoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ReservaDto> criteria = builder.createQuery(ReservaDto.class);
		Root<Solicitacao> root = criteria.from(Solicitacao.class);
		Join<Solicitacao, Recurso> recursoJoin = root.join("recursos");
		Join<Solicitacao, Pessoa> pessoaJoin = root.join("solicitante");

		List<Predicate> predicate = new ArrayList<Predicate>();
		if(!ObjectUtils.isEmpty(recursoFilter.getDataInicio()) || !ObjectUtils.isEmpty(recursoFilter.getDataFinal())) {
			predicate.add(
					builder.greaterThan(root.get("dataFinal"), recursoFilter.getDataInicio()));
			predicate.add(
					builder.lessThan(root.get("dataInicio"), recursoFilter.getDataFinal()));
		}
		if(!ObjectUtils.isEmpty(recursoFilter.getIdRecurso())) {
			predicate.add(builder.equal(recursoJoin.get("id"), recursoFilter.getIdRecurso()));			
		}
		predicate.add(builder.equal(recursoJoin.type(), Transporte.class));

		criteria.orderBy(builder.asc(root.get("dataInicio")));
		criteria.distinct(true);

		criteria.select(builder.construct(ReservaDto.class, root.get("id"), recursoJoin.get("id"),
				recursoJoin.get("descricao"), root.get("dataInicio"), root.get("dataFinal"),
				pessoaJoin.get("nome"),pessoaJoin.get("telefone").get("numero"),root.get("status")
				));

		criteria.where(builder.and(predicate.toArray(new Predicate[predicate.size()])));

		List<ReservaDto> returnList = manager.createQuery(criteria).getResultList();

		return returnList;

	}

}
