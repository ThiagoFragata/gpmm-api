package reserva_api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reserva_api.model.Equipamento;
import reserva_api.model.Local;
import reserva_api.model.Motorista;
import reserva_api.model.Pessoa;
import reserva_api.model.Recurso;
import reserva_api.model.Setor;
import reserva_api.model.Solicitacao;
import reserva_api.model.Telefone;
import reserva_api.model.Transporte;
import reserva_api.model.Viagem;
import reserva_api.model.enums.StatusSolicitacao;
import reserva_api.model.enums.TipoEquipamento;
import reserva_api.model.enums.TipoTelefone;
import reserva_api.model.enums.TipoVinculo;
import reserva_api.repositories.MotoristaRepository;
import reserva_api.repositories.PessoaRepository;
import reserva_api.repositories.RecursoRepository;
import reserva_api.repositories.SetorRepository;
import reserva_api.repositories.SolicitacaoRepository;
import reserva_api.repositories.TransporteRepository;
import reserva_api.repositories.ViagemRepository;

@SpringBootApplication
public class ReservaApiApplication implements CommandLineRunner {

	@Autowired
	SetorRepository setorRepository;

	@Autowired
	PessoaRepository pessoaRepository;

	@Autowired
	MotoristaRepository motoristaRepository;

	@Autowired
	RecursoRepository recursoRepository;

	@Autowired
	TransporteRepository transporteRepository;

	@Autowired
	SolicitacaoRepository solicitacaoRepository;

	@Autowired
	ViagemRepository viagemRepository;

	DateTimeFormatter ftr = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	DateTimeFormatter fdate = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	public static void main(String[] args) {
		SpringApplication.run(ReservaApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//TimeUnit.SECONDS.sleep(10);
		//cadastrarPessoas();
		//cadastrarRecursos();
		//cadastrarSolicitacao();
		//cadastrarViagem();
	}

	private void cadastrarViagem() {
		Motorista m1 = motoristaRepository.findById(4L).orElseThrow();
		Solicitacao sol1 = solicitacaoRepository.findById(1L).orElseThrow();
		Transporte tr1 = transporteRepository.findById(1L).orElseThrow();
		Pessoa p1 = pessoaRepository.findById(2L).orElseThrow();
		Pessoa p2 = pessoaRepository.findById(4L).orElseThrow();

		Viagem vg1 = new Viagem(null, "Itacoatiara/Manaus/Itacoatiara", "B1547899", "/arquivos/xdrweweww2.pdf", 120879L,
				null, m1, sol1, tr1);
		vg1.getPassageiros().add(p1);
		vg1.getPassageiros().add(p2);

		viagemRepository.save(vg1);

	}

	private void cadastrarSolicitacao() {
		Solicitacao sl1 = new Solicitacao(null, LocalDateTime.parse("25-04-2023 10:00", ftr),
				LocalDateTime.parse("25-04-2023 12:00", ftr), " Viagem para tabalho de campo.", LocalDateTime.now(),
				null, null, StatusSolicitacao.SOLICITADO, new Pessoa(1L));
		sl1.getRecursos().add(new Transporte(1L));
		sl1.getRecursos().add(new Equipamento(6L));
		sl1.getRecursos().add(new Local(3L));
		solicitacaoRepository.save(sl1);

	}

	private void cadastrarRecursos() {
		Recurso rc1 = new Transporte(null, "Pickup Nissan", "HTG-1262", 4);
		Recurso rc2 = new Transporte(null, "Van Mercedes-Benz", "IAD-2304", 16);

		Recurso rc3 = new Local(null, "Auditório geral", "A101", 200);
		Recurso rc4 = new Local(null, "Mini auditório", "A210", 30);
		Recurso rc5 = new Local(null, "Sala de reunião", "C101", 20);

		Recurso rc6 = new Equipamento(null, "Projeto de slide 01", "2001547", TipoEquipamento.PROJETOR);
		Recurso rc7 = new Equipamento(null, "Projeto de slide 02", "2001548", TipoEquipamento.PROJETOR);
		Recurso rc8 = new Equipamento(null, "Notebook Dell 01", "2001521", TipoEquipamento.NOTEBOOK);
		Recurso rc9 = new Equipamento(null, "Mesa de som Behringer", "2001530", TipoEquipamento.MESASOM);
		recursoRepository.saveAll(Arrays.asList(rc1, rc2, rc3, rc4, rc5, rc6, rc7, rc8, rc9));
	}

	private void cadastrarPessoas() {
		Setor st1 = new Setor(null, "Biblioteca");
		Setor st2 = new Setor(null, "Coordenação acadêmica");
		Setor st3 = new Setor(null, "Gerência de TI");
		Setor st4 = new Setor(null, "Direção");
		Setor st5 = new Setor(null, "Coordenação administrativa");
		setorRepository.saveAll(Arrays.asList(st1, st2, st3, st4, st5));

		Pessoa ps1 = new Pessoa(null, "Agatha Sueli Marcela Rezende", "424.554.048-62", "28.507.242-0",
				LocalDate.parse("04-03-1985", fdate), st1, TipoVinculo.PROFESSOR,new Telefone(TipoTelefone.CELULAR, "(47) 99468-9837"));

		Pessoa ps2 = new Pessoa(null, "Emilly Bruna de Paula", "658.439.303-86", "14.151.755-4",
				LocalDate.parse("20-04-1977", fdate), st2, TipoVinculo.PROFESSOR,new Telefone(TipoTelefone.CELULAR, "(31) 98984-6061"));

		Pessoa ps3 = new Pessoa(null, "Kevin Geraldo Benedito Ferreira", "607.641.416-27", "31.203.387-4",
				LocalDate.parse("24-10-1988", fdate), st3, TipoVinculo.PROFESSOR,new Telefone(TipoTelefone.FIXO, "(62) 3896-9585"));
		Pessoa ps4 = new Motorista(null, "Lorenzo Augusto Corte Real", "116.741.496-97", "46.063.022-2",
				LocalDate.parse("15-06-1980", fdate), st3, TipoVinculo.TERCEIRIZADO, new Telefone(TipoTelefone.FIXO, "(51) 2895-1562"),
				"60427048705");
		pessoaRepository.saveAll(Arrays.asList(ps1, ps2, ps3, ps4));
	}

}
