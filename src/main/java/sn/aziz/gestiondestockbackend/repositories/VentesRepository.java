package sn.aziz.gestiondestockbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.aziz.gestiondestockbackend.models.CommandeClient;
import sn.aziz.gestiondestockbackend.models.Ventes;

import java.util.Optional;
import java.util.stream.DoubleStream;

@Repository
public interface VentesRepository extends JpaRepository<Ventes, Integer> {
    Optional<Ventes> findVentesByCode(String code);


}
