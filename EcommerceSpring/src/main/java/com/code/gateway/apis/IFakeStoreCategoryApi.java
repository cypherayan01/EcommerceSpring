package com.code.gateway.apis;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.code.dtos.FakeStoreCategoryResponseDTO;

import retrofit2.Call;
import retrofit2.http.GET;

@Component
public interface IFakeStoreCategoryApi {

	@GET("products/category")
	Call<FakeStoreCategoryResponseDTO> getAllFakeCategories() throws IOException;
}
