/**
 * 
 */
package com.mahubet.services;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mahubet.dao.LoginDAO;

/**
 * @author samird
 *
 */
@Path("/login")
public class Login {
	
	@GET
	@Path("/test")
	@Produces("text/html")
	public String test(){
		return "application is running";
	}
	
	@POST
	@Path("/validate")
	@Produces("application/json")
	public boolean validateLogin(@FormParam("username")String username,@FormParam("password")String password){
		return new LoginDAO().validate(username, password);
	}
	
	@POST
	@Path("/signup")
	@Produces("application/json")
	public boolean addNewUser(@FormParam("username")String name,@FormParam("emailid")String userid,@FormParam("password")String password,@FormParam("mobile")String mobile){
		return new LoginDAO().addUser(userid, name, password, mobile);
	}
}
