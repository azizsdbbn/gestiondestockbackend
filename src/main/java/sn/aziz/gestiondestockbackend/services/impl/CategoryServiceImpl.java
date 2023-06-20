package sn.aziz.gestiondestockbackend.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.aziz.gestiondestockbackend.dto.CategoryDto;
import sn.aziz.gestiondestockbackend.exceptions.EntityNotFountException;
import sn.aziz.gestiondestockbackend.exceptions.Errorcodes;
import sn.aziz.gestiondestockbackend.exceptions.InvalidEntityException;
import sn.aziz.gestiondestockbackend.models.Category;
import sn.aziz.gestiondestockbackend.repositories.CategoryRepository;
import sn.aziz.gestiondestockbackend.services.CategoryService;
import sn.aziz.gestiondestockbackend.validators.CategoryValidator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        List<String> errors = CategoryValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Category is not valid {}", dto);
            throw new InvalidEntityException("La categorrie n'est pas valide", Errorcodes.ARTICLE_NOT_VALID, errors);
        }
        return CategoryDto.fromEntity(
                categoryRepository.save(
                        CategoryDto.toEntity(dto))
        );
    }

    @Override
    public CategoryDto findById(Integer id) {
        if (id == null){
            log.error("Category ID is null");
            return null;
        }
        Optional<Category> category = categoryRepository.findById(id);
        return Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow(()->
                new EntityNotFountException("Aucune categorie avec ID = " + id + "n'est pas trouvé la BDD",
                        Errorcodes.ARTICLE_NOT_FOND)
        );
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Category ID is null");
            return;
        }
        categoryRepository.deleteById(id);
    }
}
