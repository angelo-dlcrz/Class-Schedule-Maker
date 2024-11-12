package app.rest.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.SectionComponent;
import app.entities.Section;

@Component
@Path("/section")
public class SectionController {
	
	@Autowired
	SectionComponent sc;
	
	@GET
	@Path("/retrieve")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Section getSubject(@QueryParam("p") Long pk) {
		return sc.findSection(pk);
	}
	
	@GET
	@Path("/retrieveAll")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Section> getSubjectAll() {
		return sc.getAllSections();
	}
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
	public Section addSection(@FormParam("sc") String sub, @FormParam("n") String name){
		
		return sc.createSection(sub, name);	
	}

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
	public Section updateSection(@FormParam("pk") Long pk, @FormParam("sc") String sub, @FormParam("n") String name) throws Exception{
		
		return sc.updateSection(pk, sub, name);
		
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteSubject(@QueryParam("pk") Long pk) {
	    
		return sc.deleteSection(pk);
	    
	}
	
	
	
}