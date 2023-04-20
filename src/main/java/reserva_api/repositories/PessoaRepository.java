package reserva_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import reserva_api.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>  {

}
