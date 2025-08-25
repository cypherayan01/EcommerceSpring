package com.code.gateway;

import java.io.IOException;
import java.util.List;

import com.code.dtos.CategoryDTO;

public interface ICategoryGateway {

	List<CategoryDTO> getAllCategories() throws IOException ;
}
