package reserva_api.repositories.filters;

import java.time.LocalDateTime;

public class RecursoFilter {
	private Long idRecurso;
	
	private LocalDateTime dataInicio;
	
	private LocalDateTime dataFinal;

	public RecursoFilter() {
		super();
	}

	public RecursoFilter(Long idRecurso, LocalDateTime dataInicio, LocalDateTime dataFinal) {
		super();
		this.idRecurso = idRecurso;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
	}

	public Long getIdRecurso() {
		return idRecurso;
	}

	public void setIdRecurso(Long idRecurso) {
		this.idRecurso = idRecurso;
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDateTime getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDateTime dataFinal) {
		this.dataFinal = dataFinal;
	}

}
