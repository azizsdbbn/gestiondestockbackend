package sn.aziz.gestiondestockbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.aziz.gestiondestockbackend.models.Article;

@Repository
public interface RolesRepository extends JpaRepository<Article, Integer> {
}
