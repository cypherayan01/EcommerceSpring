package com.code.gateway;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.code.dtos.CategoryDTO;
import com.code.dtos.FakeStoreCategoryResponseDTO;
import com.code.gateway.apis.IFakeStoreCategoryApi;

@Component
public class FakeStoreCategoryGateway implements ICategoryGateway{
	
	private final IFakeStoreCategoryApi fakeStoreCategoryApi;
	
	public FakeStoreCategoryGateway(IFakeStoreCategoryApi _fakeStoreCategoryApi) {
		this.fakeStoreCategoryApi =_fakeStoreCategoryApi;
	}

	@Override
	public List<CategoryDTO> getAllCategories() throws IOException {
		// TODO Auto-generated method stub
		 FakeStoreCategoryResponseDTO response = this.fakeStoreCategoryApi
				 .getAllFakeCategories().execute().body();
		 
		 if (response == null || response.getCategories() == null) {
		        throw new IOException("Failed to fetch categories from Fakestore apis.");
		    }
		 return response.getCategories()
				 .stream().map(category -> CategoryDTO.builder()
						 .name(category).build())
		 			.toList();
	}

}
