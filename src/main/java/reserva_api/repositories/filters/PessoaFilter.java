package reserva_api.repositories.filters;

import java.time.LocalDate;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import reserva_api.model.enums.TipoVinculo;

public class PessoaFilter {
	private String nome;
	private String cpf;
	private String siape;
	private LocalDate dataNascimento;
	@Enumerated(EnumType.STRING)
	private TipoVinculo tipoVinculo;
	
	public PessoaFilter(String nome, String cpf, String siape, LocalDate dataNascimento, TipoVinculo tipoVinculo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.siape = siape;
		this.dataNascimento = dataNascimento;
		this.tipoVinculo = tipoVinculo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSiape() {
		return siape;
	}

	public void setSiape(String siape) {
		this.siape = siape;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public TipoVinculo getTipoVinculo() {
		return tipoVinculo;
	}

	public void setTipoVinculo(TipoVinculo tipoVinculo) {
		this.tipoVinculo = tipoVinculo;
	}
	
}
