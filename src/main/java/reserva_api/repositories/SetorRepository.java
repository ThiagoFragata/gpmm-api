package reserva_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import reserva_api.model.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long>  {

}
