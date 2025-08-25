package com.code.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.dtos.CategoryDTO;
import com.code.services.ICategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	private final ICategoryService categoryService;
	
	
	public CategoryController(ICategoryService _categoryService){
		this.categoryService=_categoryService;
		
	}
	
	@GetMapping
	public List<CategoryDTO> getAllCategories() throws IOException {
		return this.categoryService.getAllCategories();
		
	}

}
