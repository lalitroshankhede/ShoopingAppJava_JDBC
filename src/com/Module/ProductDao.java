package com.Module;

import java.util.List;

import com.bean.Product;

 

public interface ProductDao {
	public void insertProduct();
	public void updateProduct();
	public void deleteProduct();
	public void getSingleData();
	public List<Product> getProducts();
	public List<Product> getNoProducts();
}
