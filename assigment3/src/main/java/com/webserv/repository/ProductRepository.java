package com.webserv.repository;

import java.util.List;

import com.webserv.model.Product;

public interface ProductRepository {
	public List<Product> getAll();
	public Product getById(int id);
	public int save(Product product);
	public boolean deleteById(int id);
}
