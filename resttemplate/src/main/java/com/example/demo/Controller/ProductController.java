package com.example.demo.Controller;

import java.awt.PageAttributes.MediaType;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.Product;
import com.example.demo.Service.ProductService;

@RestController
public class ProductController {
	
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getProducts()
	{
		return productService.get();
	}
	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product product)
	{
		return productService.save(product);
	}
	@PutMapping("/product/{id}")
	public String updateProduct(@PathVariable int id,@RequestBody Product product)
	{
		productService.saveById(id,product);
		
		return "product updated";	
		}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id)
	{
		productService.deleteId(id);
	}
	@GetMapping("/{id}")
	public Optional<Product> getById(@PathVariable int id)
	{
		return productService.getById(id);
	}
}
