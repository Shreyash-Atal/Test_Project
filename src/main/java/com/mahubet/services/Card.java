package com.mahubet.services;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mahubet.dao.CardDAO;
@Path("/card")
public class Card {
	@GET
	@Path("/testCard")
	@Produces("text/html")
	public String test(){
		return "Card application is running";
	}
	
	@POST
	@Path("/validate")
	@Produces("application/json")
	public boolean validateCard(@FormParam("card_id")int card_id){
		return new CardDAO().validate(card_id);
	}
	
	@POST
	@Path("/card")
	@Produces("application/json")
	public boolean addNewCard(@FormParam("card_id")int card_id,@FormParam("cname")String cname,@FormParam("filepath")String filepath,@FormParam("price")int price,@FormParam("keyword")String keyword){
		return new CardDAO().addCard(card_id, cname, filepath, keyword,price);
	}
}
