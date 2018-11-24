package com.holkem;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/*
 * @SOAPBinding(style=Style.RPC) : more readable compared to Document
 * but lesser used than document
 * 
 * @WebResult(partName="lookupOutput") : renames the tags shown in method execution
 * @WebParam(partName="lookupInput") : renames the tags shown in method execution
 * 
 * Class Throwing an Exception will automatically update wsdl with this exception 
 * <xs:complexType name="InvalidInputException">
 * <xs:element name="faultInfo" type="xs:string" minOccurs="0"/>
 * <xs:element name="message" type="xs:string" minOccurs="0"/>
 */

@WebService
//@SOAPBinding(style=Style.RPC)
public class ShopInfo {
	
	@WebMethod
	@WebResult(partName="lookupOutput")
	public String getShopInfo(@WebParam(partName="lookupInput") String property) throws InvalidInputException {
		String ret = null;
		if ("shop info".equals(property)) {
			ret = "Test Mart";
		} else if ("since".equals(property)) {
			ret = "since 2012";
		} else {
			throw new InvalidInputException("Invalid Input", property + " is not a valid input");
		}
		return ret;
	}
}
