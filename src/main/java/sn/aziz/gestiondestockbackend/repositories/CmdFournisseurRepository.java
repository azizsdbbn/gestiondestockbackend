package sn.aziz.gestiondestockbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.aziz.gestiondestockbackend.models.CommandeClient;
import sn.aziz.gestiondestockbackend.models.CommandeFournisseur;

import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

@Repository
public interface CmdFournisseurRepository extends JpaRepository<CommandeFournisseur, Integer> {
    Optional<CommandeFournisseur> findCommandeFournisseurByCode(String code);
    List<CommandeClient> findAllByFournisseurId(Integer id);
}
