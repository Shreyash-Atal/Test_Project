package com.mahubet.services;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mahubet.dao.CardDAO;
import com.mahubet.dao.PurchaseDAO;

@Path("/purchase")
public class Purchase {
	@GET
	@Path("/testPurchase")
	@Produces("text/html")
	public String test(){
		return "Purchase application is running";
	}
	
	@POST
	@Path("/validate")
	@Produces("application/json")
	public boolean validateCard(@FormParam("purchase_id")int purchase_id){
		return new PurchaseDAO().validate(purchase_id);
	}
	
	@POST
	@Path("/purchase")
	@Produces("application/json")
	public boolean addNewCard(@FormParam("purchase_id")int purchase_id,@FormParam("user_id")int user_id,@FormParam("card_id")int card_id,@FormParam("cpath")String cpath,@FormParam("payment_status")String payment_status,@FormParam("address")String addresses,@FormParam("phone_number")int phone_number,@FormParam("quantity")int quantity,@FormParam("amount")String amount){
		return new PurchaseDAO().purchase(purchase_id,user_id,card_id, cpath, payment_status, addresses,phone_number,quantity,amount);
	}
}
