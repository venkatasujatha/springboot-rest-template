package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Model.Product;

public interface ProductService {

	List<Product> get();

	Product save(Product product);


	

	String saveById(int id, Product product);

	

	Optional<Product> getById(int id);

	void deleteId(int id);

}
