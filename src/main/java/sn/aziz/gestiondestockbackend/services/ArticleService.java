package sn.aziz.gestiondestockbackend.services;

import sn.aziz.gestiondestockbackend.dto.ArticleDto;

import java.util.List;

public interface ArticleService {

    ArticleDto save(ArticleDto dto);
    ArticleDto findById(Integer id);
    ArticleDto findByCode(String code);
    List<ArticleDto> findAll();
    void delete(Integer id);
}
