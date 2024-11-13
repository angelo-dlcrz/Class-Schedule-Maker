package app.components;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.TimeSlot;
import app.entities.User;
import app.repositories.TimeSlotRepository;
import app.repositories.UserRepository;

@Component
public class TimeSlotComponent {
	
	@Autowired
	private TimeSlotRepository tsRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	public List<TimeSlot> getAllTimeSlots(){
		return tsRepo.findAll();
	}
	
	public TimeSlot getTimeSlot(Long pk) {
		return tsRepo.findByPk(pk);
	}
	
	public TimeSlot createTimeSlot(Long studentID) {
		TimeSlot ts = new TimeSlot();
		User user = userRepo.findByStudentID(studentID);
		if(user==null) {
			throw new EntityNotFoundException(String.format("User with studentID: %d not found.", studentID));
		}
		ts.setUser(user);
		return tsRepo.save(ts);
	}
	
	public String deleteTimeSlot(Long pk) {
		if(tsRepo.findByPk(pk) == null) {
			return "TimeSlot not found";
		}
		tsRepo.deleteByPk(pk);
		return String.format("TimeSlot with pk %d has been successfully deleted.", pk);
	}
}
