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
	
	//	public Section createSection(String name, String dayOfTheWeekSchedule, String timeStart, String timeEnd, int slots, String subjectCode, String roomName, String instructor) {

	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
	public Section addSection(@FormParam("n") String name,
							@FormParam("d") String dayOfTheWeekSchedule,
							@FormParam("ts") String timeStart, 
							@FormParam("te") String timeEnd, 
							@FormParam("s") int slots,
							@FormParam("sc") String subjectCode,
							@FormParam("rn") String roomName,
							@FormParam("i") String instructor){
		
		return sc.createSection(name, dayOfTheWeekSchedule, timeStart, timeEnd, slots, subjectCode, roomName, instructor);
	}

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
	public Section updateSection(
			@FormParam("pk") Long pk,
			@FormParam("n") String name,
			@FormParam("d") String dayOfTheWeekSchedule,
			@FormParam("ts") String timeStart, 
			@FormParam("te") String timeEnd, 
			@FormParam("s") int slots,
			@FormParam("sc") String subjectCode,
			@FormParam("rn") String roomName,
			@FormParam("i") String instructor){

return sc.updateSection(pk,name, dayOfTheWeekSchedule, timeStart, timeEnd, slots, subjectCode, roomName, instructor);
}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteSubject(@QueryParam("pk") Long pk) {
	    
		return sc.deleteSection(pk);
	    
	}
	
	
	
}