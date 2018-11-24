package com.holkem;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.holkem.model.Product;

@WebService()
public interface ProductCatalogInterface {

	@WebMethod()
	List<String> getProductCategories();
	
	@WebMethod
	boolean addProducts(String cat, String prdt);


	@WebMethod
	List<String> getProducts(String cat);

	@WebMethod
	List<Product> getProductsv2(String cat);
}