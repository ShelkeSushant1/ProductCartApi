package com.jspiders.springboot.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springboot.repository.ProductRepository;
import com.jspiders.springboot.response.ResponseStructure;
import com.jspiders.springboot.comparator.PriceComparator;
import com.jspiders.springboot.comparator.RatingComparator;
import com.jspiders.springboot.pojo.Product;
import com.jspiders.springboot.pojo.User;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public Product addProduct(Product product) {
		return productRepository.save(product);

	}

	public Object findProductById(long id) {
		// TODO Auto-generated method stub
		Optional<Product> optional = productRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();

		} else {
			return "Product is not found";
		}

	}

	public Object findAllProducts() {
		// TODO Auto-generated method stub
		List<Product> products = productRepository.findAll();
		if(products.size()>0) {
			return products;
		}else {
			return "products not found";
		}
		
		
	}


	public List<Product> findProductsByCategory(String category) {
		// TODO Auto-generated method stub
		List<Product>products=productRepository.findProductsByCategory(category);
		if(products.size()>0) {
			return products;
		}
		else {
			return null;
		}
	}

	public Object sortProductsByRating() {
		// TODO Auto-generated method stub
		List<Product> products = productRepository.findAll();
		if(products.size()>0) {
			Collections.sort(products,new RatingComparator());
			return products;
		}
		else {
			return "NO PRODUCTS FOUND";
		}
	}

	public Object sortProductsByPrice() {
		// TODO Auto-generated method stub
		List<Product> products = productRepository.findAll();
		if(products.size()>0) {
			Collections.sort(products,new PriceComparator());
			return products;
		}else {
			return "NO PRODUCTS FOUND";
		}
		
	}

	

	public Object deleteProduct(long id) {
		// TODO Auto-generated method stub
		Optional<Product> optional = productRepository.findById(id);
		if(optional.isPresent()) {
			Product product = optional.get();
			productRepository.delete(product);
			return optional;
		}else {
			return "Product not found";
		}
		
		
	}

	

	public Object updateProduct(long id, Product product) {
		// TODO Auto-generated method stub
		Optional<Product> optionalProduct = productRepository.findProductById(id);
		if (optionalProduct.isPresent()) {
            Product product2 = optionalProduct.get();
            product2.setName(product.getName());
            product2.setBrand(product.getBrand());
            product2.setCategory(product.getCategory());
            product2.setDescription(product.getDescription());
            product2.setPrice(product.getPrice());
            product2.setRating(product2.getRating());
            productRepository.save(product2);
            return product2;
        } else {
            return "product not found";
        }
		
	 
		
	}

	

}