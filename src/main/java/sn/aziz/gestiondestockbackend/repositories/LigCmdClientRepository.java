package sn.aziz.gestiondestockbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.aziz.gestiondestockbackend.models.CommandeClient;
import sn.aziz.gestiondestockbackend.models.LigneCommandeClient;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface LigCmdClientRepository extends JpaRepository<LigneCommandeClient, Integer> {

    List<LigneCommandeClient> findAllByCommandeClientId(Integer id);

    List<LigneCommandeClient> findAllByArticleId(Integer id);
}
