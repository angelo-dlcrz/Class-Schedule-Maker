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

import app.components.TimeSlotComponent;
import app.entities.TimeSlot;

@Component
@Path("/timeslot")
public class TimeSlotController {
	
	@Autowired
	private TimeSlotComponent tsComp;
	
	@GET
	@Path("/retrieveAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TimeSlot> getAllTimeSlots(){
		return tsComp.getAllTimeSlots();
	}
	
	@GET
	@Path("/retrieve")
	@Produces(MediaType.APPLICATION_JSON)
	public TimeSlot getTimeSlot(@QueryParam("pk") Long pk) {
		return tsComp.getTimeSlot(pk);
	}
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public TimeSlot createTimeSlot(@FormParam("sid") Long studentID) {
		return tsComp.createTimeSlot(studentID);
	}
	
	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteTimeSlot(@QueryParam("pk") Long pk) {
		return tsComp.deleteTimeSlot(pk);
	}
}
