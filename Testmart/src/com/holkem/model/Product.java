package com.holkem.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="ProductClass")
@XmlType(propOrder= {"price", "sku", "name"})
public class Product {
	private String name;
	private String sku;
	private double price;
	
	public Product(String name, String sku, double price) {
		this.name = name;
		this.sku = sku;
		this.price = price;
	}
	
	/* no-args constructor needs to be set up for JAXB implementation
	 * bec it needs to instantiate the object first before it adds 
	 * the values. it is important to note that this is due to JAXB
	 * using the getters to do java-class-to-xml-conversion and setters
	 * to do the xml-to-java-class-conversion */ 
	public Product() { }

	@XmlElement(name="ProductName")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
