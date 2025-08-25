package com.code.configuration;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.code.gateway.apis.IFakeStoreCategoryApi;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {
	
	@Bean
	public Retrofit retrofit() throws Exception {
		TrustManager[] trustAllCerts = new TrustManager[]{
	            new X509TrustManager() {
	                public void checkClientTrusted(X509Certificate[] chain, String authType) {}
	                public void checkServerTrusted(X509Certificate[] chain, String authType) {}
	                public X509Certificate[] getAcceptedIssuers() { return new X509Certificate[0]; }
	            }
	        };

	        SSLContext sslContext = SSLContext.getInstance("TLS");
	        sslContext.init(null, trustAllCerts, new SecureRandom());

	        OkHttpClient okHttpClient = new OkHttpClient.Builder()
	                .sslSocketFactory(sslContext.getSocketFactory(), (X509TrustManager) trustAllCerts[0])
	                .hostnameVerifier((hostname, session) -> true) // ignore hostname check
	                .connectTimeout(30, TimeUnit.SECONDS)
	                .readTimeout(30, TimeUnit.SECONDS)
	                .build();
	        
		return new Retrofit.Builder()
				  .baseUrl("https://fakestoreapi.in/api/")
				  .addConverterFactory(GsonConverterFactory.create())
				  .client(okHttpClient)
				  .build();
	}
	
	@Bean
	public IFakeStoreCategoryApi fakeStoreCategoryApi(Retrofit retrofit) {
		
		return retrofit.create(IFakeStoreCategoryApi.class);
	}

}
