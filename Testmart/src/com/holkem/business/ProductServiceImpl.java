package com.holkem.business;

import java.util.ArrayList;
import java.util.List;

import com.holkem.model.Product;

public class ProductServiceImpl {
	private List<String> bookList = new ArrayList<>();
	private List<String> musicList = new ArrayList<>();
	private List<String> movieList = new ArrayList<>();

	public ProductServiceImpl() {
		bookList.add("book1");
		bookList.add("book2");
		bookList.add("book3");
		
		musicList.add("music1");
		musicList.add("music2");
		musicList.add("music3");
		
		movieList.add("movie1");
		movieList.add("movie2");
		movieList.add("movie3");
	}

	public List<String> getProductCategories() {
		List<String> cat = new ArrayList<>();
		cat.add("Books");
		cat.add("Music");
		cat.add("Movies");
		return cat;
	}
	
	public List<String> getProducts(String cat) {
		switch(cat.toLowerCase()) {
		case "books":
			return bookList;
		case "music":
			return musicList;
		case "movies":
			return movieList;
		default:
			return null;
		}
	}
	
	public boolean addProducts(String cat, String prdt) {
		switch(cat.toLowerCase()) {
		case "books":
			bookList.add(prdt);
			break;
		case "music":
			musicList.add(prdt);
			break;
		case "movies":
			movieList.add(prdt);
			break;			
		default:
			return false;
		}
		return true;
	}

	public List<Product> getProductsv2(String cat) {
		List<Product> list = new ArrayList<>();
		list.add(new Product("Product1", "1234", 100.00));
		list.add(new Product("Product2", "1236", 200.00));
		return list;
	}
}
