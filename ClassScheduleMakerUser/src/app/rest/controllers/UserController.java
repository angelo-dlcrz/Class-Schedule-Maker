package app.rest.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public User createUser(@FormParam("n") String name, @FormParam("c") String course, @FormParam("pn") String phoneNumber) {
    	return uc.createUser(name, course, phoneNumber);
    }
    
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public User updateUser(@FormParam("pk") Long studentID, @FormParam("n") String name, @FormParam("c") String course, @FormParam("pn") String phoneNumber) {
    	return uc.updateUser(studentID, name, course, phoneNumber);
    }
    
    @POST
    @Path("/addSection")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public User updateUser(@FormParam("stupk") Long studentID, @FormParam("secpk") Long sectionPk) {
    	return uc.addSection(studentID, sectionPk);
    }
    
    @PUT
    @Path("/updateSection")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public User updateUser(@FormParam("stupk") Long studentID, @FormParam("oldsec") Long oldSectionPk, @FormParam("newsec") Long newSectionPk) {
    	return uc.updateSection(studentID, oldSectionPk, newSectionPk);
    }
    
    @DELETE
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteUser(@QueryParam("pk") Long studentID) {
    	return uc.deleteUser(studentID);
    }
}
