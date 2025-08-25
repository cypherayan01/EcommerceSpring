package com.code.services;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.code.dtos.CategoryDTO;
import com.code.gateway.ICategoryGateway;

@Service
public class FakeStoreCategoryService implements ICategoryService {

	private final ICategoryGateway categoryGateway;

	public FakeStoreCategoryService(ICategoryGateway _categoryGateway) {
		this.categoryGateway = _categoryGateway;
	}

	@Override
	public List<CategoryDTO> getAllCategories() throws IOException {
		// TODO Auto-generated method stub
		try {
			return this.categoryGateway.getAllCategories();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return List.of();
		
	}

}
