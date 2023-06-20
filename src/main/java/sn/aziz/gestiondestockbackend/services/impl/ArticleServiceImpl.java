package sn.aziz.gestiondestockbackend.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sn.aziz.gestiondestockbackend.dto.ArticleDto;
import sn.aziz.gestiondestockbackend.exceptions.EntityNotFountException;
import sn.aziz.gestiondestockbackend.exceptions.Errorcodes;
import sn.aziz.gestiondestockbackend.exceptions.InvalidEntityException;
import sn.aziz.gestiondestockbackend.models.Article;
import sn.aziz.gestiondestockbackend.repositories.ArticleRepository;
import sn.aziz.gestiondestockbackend.services.ArticleService;
import sn.aziz.gestiondestockbackend.validators.ArticleValidator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        List<String> errors = ArticleValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Article is not valid {}", dto);
            throw new InvalidEntityException("L'article n'est pas valide", Errorcodes.ARTICLE_NOT_VALID, errors);
        }
        return ArticleDto.fromEntity(
                articleRepository.save(
                        ArticleDto.toEntity(dto))
        );
    }

    @Override
    public ArticleDto findById(Integer id) {
        if (id == null){
            log.error("Article ID is null");
            return null;
        }
        Optional<Article> article = articleRepository.findById(id);
        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(()->
        new EntityNotFountException("Aucun article avec ID = " + id + "n'est pas trouvé la BDD",
                Errorcodes.ARTICLE_NOT_FOND)
        );
    }

    @Override
    public ArticleDto findByCode(String code) {
        if (!StringUtils.hasLength(code)){
            log.error("Article CODE is null");
            return null;
        }
        Optional<Article> article = articleRepository.findArticleByCode(code);
        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(()->
                new EntityNotFountException("Aucun article avec CODE = " + code + "n'est pas trouvé la BDD",
                        Errorcodes.ARTICLE_NOT_FOND)
        );
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Article ID is null");
            return;
        }
        articleRepository.deleteById(id);

    }
}
