package sn.aziz.gestiondestockbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.aziz.gestiondestockbackend.models.CommandeClient;

import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

@Repository
public interface CmdClientRepository extends JpaRepository<CommandeClient, Integer> {
    Optional<CommandeClient> findCommandeClientByCode(String code);
    List<CommandeClient> findAllByClientId(Integer id);

}
