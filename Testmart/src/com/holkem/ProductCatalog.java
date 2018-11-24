package com.holkem;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.holkem.business.ProductServiceImpl;
import com.holkem.model.Product;

/*
 * @WebService : annotation making the whole class a WebService,
 * 	meaning that any public method defined inside this class
 * 	will be automatically be treated as if u explicitly annotated
 *  it with @WebMethod
 * list of params:
 * 1. name = for endpoint and portType name
 * 2. portName = for port and portbinding
 * 3. serviceName = changes  Endpoint Address URI: /Testmart/TestMartCatalogService
 * 4. targetNamespace = changes domain diff from ur package name
 *  
 * @WebMethod : service method
 * 1. action = <operation name="fetchCategories">
 * 2. operationName = <soap:operation soapAction="fetch_categories"/>
 * 
 * @WebResult : result from method
 * 1. name = is the name used in the result of operation
 * 
 * WSDL : flow hierarchy
 * Service:
 * 	 Port
 *   Binding:
 *     Port Type:
 *       Operations:
 *         Input Msgs (# of input) => Types
 *         Output Msgs => Types  
 *         
 * NOTE: extracted an interface. but most of the annotations is defined here
 * but there are some missing tags in the wsdl so removed the interface 
 * implementation here
 */

@WebService(name="TestMartCatalog", serviceName="TestMartCatalogService", 
			portName="TestMartCat", targetNamespace="http://testmart.com")
public class ProductCatalog {
	ProductServiceImpl productService = new ProductServiceImpl();
	
	@WebMethod(action="fetch_categories", operationName="fetchCategories")
	public List<String> getProductCategories() {
		return productService.getProductCategories();
	}
	
	public boolean addProducts(String cat, String prdt) {
		return productService.addProducts(cat, prdt);
	}
	
	public List<String> getProducts(String cat) {
		return productService.getProducts(cat);
	}
	
	/* getProducts version2 : instead of List<String> will use List<Product> 
	 * esp if wsdl is already been deployed and in use. Clients can decide if
	 * they want to upgrade, use the newer version */
	@WebResult(name="Product") 
	public List<Product> getProductsv2(@WebParam(name="category") String cat) {
		return productService.getProductsv2(cat);
	}
}
