package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepository;

@Service
public class ProductServiceIMpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> get() {
		
		return productRepository.findAll();
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

		@Override
	public String saveById(int id,Product product) {
		
			Product id2 = productRepository.getById(id);
			String id3 = id2.getName();
			id2.setName(id3);
			productRepository.save(product);
		 return "updated";
		
	}

		@Override
		public void deleteId(int id) {
			
			productRepository.deleteById(id);
			
		}

		@Override
		public Optional<Product> getById(int id) {
			
			return productRepository.findById(id);
			
		}

	

}
