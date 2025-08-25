package com.code.services;

import java.io.IOException;
import java.util.List;

import com.code.dtos.CategoryDTO;

public interface ICategoryService {

	List<CategoryDTO> getAllCategories() throws IOException;
}
