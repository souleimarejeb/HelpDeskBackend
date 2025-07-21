package com.helpdesk.services;
import com.helpdesk.repositories.CategoryRepository;
import com.helpdesk.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
@Autowired
private CategoryRepository categoryRepository;

public List<Category> getAllCategories() {
	return categoryRepository.findAll();}

public Category CreateCategory(Category category) {
    return categoryRepository.save(category);
}

public Optional<Category> updateCategory(int id, Category updatedCategory) {
    return categoryRepository.findById(id).map(existingCategory -> {
        existingCategory.setName(updatedCategory.getName());
        existingCategory.setDescription(updatedCategory.getDescription());
        return categoryRepository.save(existingCategory);
    });
}

public void deleteCategory(int id) {
    categoryRepository.deleteById(id);
}
}
