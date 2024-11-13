package app.rest.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.UserComponent;
import app.entities.User;

@Component
@Path("/user")
public class UserController {

    @Autowired
    private UserComponent uc;

    @GET
    @Path("/retrieveAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAll(){
    	return uc.getAllUsers();
    }
    
    @GET
    @Path("/retrieve")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@QueryParam("pk") Long studentID) {
        return uc.findUser(studentID);
    }
    
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User createUser(@FormParam("n") String name, @FormParam("c") String course, @FormParam("pn") String phoneNumber) {
    	return uc.createUser(name, course, phoneNumber);
    }
    
    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User updateUser(@FormParam("pk") Long studentID, @FormParam("n") String name, @FormParam("c") String course, @FormParam("pn") String phoneNumber) {
    	return uc.updateUser(studentID, name, course, phoneNumber);
    }
    
    @GET
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUser(@QueryParam("pk") Long studentID) {
    	uc.deleteUser(studentID);
    }
}
