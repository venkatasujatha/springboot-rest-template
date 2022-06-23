package com.example.demo.Controller;

import java.awt.PageAttributes.MediaType;
import java.net.http.HttpHeaders;
import java.util.Arrays;
import java.util.HashMap;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.Product;

public class RestClient {
	
	private static final String GET_ALL_PRODUCTS_API="http://localhost:9090/products";
	private static final String CREATE_PRODUCT_API="http://localhost:9090/save";
	private static final String UPDATE_PRODUCT_API="http://localhost:9090/product/{id}";
	private static final String DELETE_PRODUCT_API="http://localhost:9090/{id}";
	private static final String GET_PRODUCTS_ById_API="http://localhost:9090/{id}";
	
	
	 static RestTemplate restTemplate=new RestTemplate();
	
	public static void main(String[] args) {
		callGetAllProductsApi();
		callGetProductById();
		callCreateProductApi();
		callUpdateProductApi();
		callDeleteApi();
		
	}
	public static void callGetAllProductsApi()
	{
		org.springframework.http.HttpHeaders headers=new org.springframework.http.HttpHeaders();
		headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
		HttpEntity<String> entity=new HttpEntity<>("parameters",headers);
		ResponseEntity<String> exchange = restTemplate.exchange(GET_ALL_PRODUCTS_API, HttpMethod.GET, entity, String.class);
		System.out.println(exchange);
	}
	
	public static void callGetProductById()
	{
		HashMap<String, Integer> entity=new HashMap<>();
		entity.put("id",1);
		Product product = restTemplate.getForObject(GET_PRODUCTS_ById_API, Product.class, entity);
		System.out.println(product.getId());
		System.out.println(product.getName());
		
	}
	
	public static void callCreateProductApi()
	{
		Product p=new Product(2, "teena");
		ResponseEntity<Product> forEntity = restTemplate.postForEntity(CREATE_PRODUCT_API, p, Product.class);
		System.out.println(forEntity.getBody());
	
	}
	
	public static void callUpdateProductApi()
	{
		HashMap<String, Integer> uii=new HashMap<>();
		uii.put("id", 2);
		Product product=new Product(2,"ututu");
		restTemplate.put(UPDATE_PRODUCT_API, product, uii);
		
		System.out.println("hshs");
	}
	
	public static void callDeleteApi()
	{
		HashMap<String, Integer> hash=new HashMap<>();
		hash.put("id", 5);
		restTemplate.delete(DELETE_PRODUCT_API, hash);
	}
	
	
	

}
