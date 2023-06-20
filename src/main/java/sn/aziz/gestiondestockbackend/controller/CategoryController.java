package sn.aziz.gestiondestockbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sn.aziz.gestiondestockbackend.controller.api.CategoryApi;
import sn.aziz.gestiondestockbackend.dto.CategoryDto;
import sn.aziz.gestiondestockbackend.services.CategoryService;


import java.util.List;

@RestController
public class CategoryController implements CategoryApi {

    private CategoryService categoryService;
    @Autowired
    public void setArticleService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @Override
    public CategoryDto save(CategoryDto dto) {
        return categoryService.save(dto);
    }
    @Override
    public CategoryDto findById(Integer id) {
        return categoryService.findById(id);
    }
    @Override
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }
    @Override
    public void delete(Integer id) {
        categoryService.delete(id);
    }
}
