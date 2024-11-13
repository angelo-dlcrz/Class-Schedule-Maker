package app.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.TimeSlot;
import app.repositories.TimeSlotRepository;

@Component
public class TimeSlotComponent {
	
	@Autowired
	private TimeSlotRepository tsRepo;
	
	public List<TimeSlot> getAllTimeSlots(){
		return tsRepo.findAll();
	}
	
	public TimeSlot getTimeSlot(Long pk) {
		return tsRepo.findByPk(pk);
	}
	
	public TimeSlot createTimeSlot() {
		return tsRepo.save(new TimeSlot());
	}
	
	public TimeSlot updateTimeSlot() {
		
	}
	
	public String deleteTimeSlot(Long pk) {
		if(tsRepo.findByPk(pk) == null) {
			return "TimeSlot not found";
		}
		tsRepo.deleteByPk(pk);
		return String.format("TimeSlot with pk %d has been successfully deleted.", pk);
	}
}
