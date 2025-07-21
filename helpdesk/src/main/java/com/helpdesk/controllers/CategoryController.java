package com.helpdesk.controllers;
import com.helpdesk.entities.Category;
import com.helpdesk.entities.Ticket;
import com.helpdesk.services.CategoryService;
import com.helpdesk.services.TicketService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
@Autowired
private CategoryService categoryService;
@GetMapping("")
public List<Category> getAllCategories() {
    return categoryService.getAllCategories();
}
@PostMapping
public ResponseEntity<Category>CreateCategory(@RequestBody Category category ){
	Category savedCategory = categoryService.CreateCategory(category);
	return ResponseEntity.ok(savedCategory);	
}

@PutMapping("/{id}")
public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category updatedCategory) {
    Optional<Category> category = categoryService.updateCategory(id, updatedCategory);
    return category.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
}




@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable int id) {
    categoryService.deleteCategory(id);  
    return ResponseEntity.ok().build();
}


}
