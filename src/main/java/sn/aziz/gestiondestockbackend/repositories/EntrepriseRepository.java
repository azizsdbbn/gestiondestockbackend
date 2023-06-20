package sn.aziz.gestiondestockbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.aziz.gestiondestockbackend.models.Entreprise;


@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

}
