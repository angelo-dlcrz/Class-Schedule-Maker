package app.components;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.Section;
import app.entities.Subject;
import app.entities.Instructor;
import app.entities.Room;
import app.repositories.SectionRepository;
import app.repositories.SubjectRepository;
import app.repositories.InstructorRepository;
import app.repositories.RoomRepository;



@Component
public class SectionInitializer {
	@Autowired
	private SectionRepository sectRepo;
	
	@Autowired 
	private SubjectRepository subjRepo;
	
	@Autowired
	private RoomRepository roomRepo;
	
	@Autowired
	private InstructorRepository insRepo;
	
	@PostConstruct
	public void init() {
		if(sectRepo.count()==0) {
			
			

			
			Section sect[] = new Section[1];
			for(int x = 0; x <= 0 ; x++) {
				sect[x] = new Section() ; //
				
			}
			
			
			sect[0].setSectionName("A1");
			sect[0].setDayOfTheWeekSchedule("M-TH");
			sect[0].setTimeEnd("2:00");
			sect[0].setTimeStart("12:30");
			sect[0].setRoom(null);
			sect[0].setSubject(null);
			sect[0].setSlots(30);
			sect[0].getInstructors().add(null);
			
			
			


			
			for(int x = 0; x <= 0; x++) {
				sectRepo.save(sect[x]);
			}
		

		}
	}
}
