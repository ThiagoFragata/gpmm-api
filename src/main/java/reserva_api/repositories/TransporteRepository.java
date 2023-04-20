package reserva_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import reserva_api.model.Transporte;

@Repository
public interface TransporteRepository extends JpaRepository<Transporte, Long>  {

}
