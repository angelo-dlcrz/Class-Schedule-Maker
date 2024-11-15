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

import app.components.SubjectComponent;
import app.entities.Subject;

@Component
@Path("/subject")
public class SubjectController {
	
	@Autowired
	SubjectComponent sc;
	
	@GET
	@Path("/retrieve")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Subject getSubject(@QueryParam("p") Long pk) {
		return sc.findSubject(pk);
	}
	
	@GET
	@Path("/retrieveAll")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Subject> getSubjectAll() {
		return sc.findSubjectAll();
	}
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
	public Subject addSubject(
							  @FormParam("sc") String subjectCode,
							  @FormParam("c") String category, 
							  @FormParam("n") String name, 
							  @FormParam("dw") String dayOfTheWeek, 
							  @FormParam("ts") String timeStart, 
							  @FormParam("te") String timeEnd,
							  @FormParam("d") String department,
							  @FormParam("dr") String departmentRestrictions,
							  @FormParam("s") int slots){
		
		return sc.addSubject(subjectCode,category, name, dayOfTheWeek, timeStart, timeEnd, department, departmentRestrictions, slots);
		
	}

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
	public Subject updateSubject(
							  @FormParam("pk") Long pk,
							  @FormParam("sc") String subjectCode,
							  @FormParam("c") String category, 
							  @FormParam("n") String name, 
							  @FormParam("dw") String dayOfTheWeek, 
							  @FormParam("ts") String timeStart, 
							  @FormParam("te") String timeEnd,
							  @FormParam("d") String department,
							  @FormParam("dr") String departmentRestrictions,
							  @FormParam("s") int slots) throws Exception{
		
		return sc.updateSubject(pk,subjectCode,category, name, dayOfTheWeek, timeStart, timeEnd, department, departmentRestrictions, slots);
		
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteSubject(@QueryParam("pk") Long pk) {
	    
		return sc.deleteSubject(pk);
	    
	}
	
	
	
}