package app.components;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.Instructor;
import app.repositories.InstructorRepository;

@Component

public class InstructorInitializer {
	@Autowired
	private InstructorRepository instructRepo;
	
	@PostConstruct
	public void init() {
		if(instructRepo.count()==0) {
			
			Instructor instructor[] = new Instructor[2];
			for(int x = 0; x <= 1 ; x++) {
				instructor[x] = new Instructor() ; //
				
			}
			
			
			instructor[0].setName("Asterion Delabat");
<<<<<<< Updated upstream
			instructor[0].setCourseHandled("CSCI 41");

			instructor[1].setName("Jacoby Cano");
			instructor[1].setCourseHandled("THEO 12");
	


			
=======
//			instructor[0].setCourseHandled("THEO 11");
//			instructor[0].setSections("B2");

			instructor[1].setName("Jacoby Cano");
//			instructor[1].setCourseHandled("THEO 12");
	
>>>>>>> Stashed changes
			for(int x = 0; x <= 1; x++) {
				instructRepo.save(instructor[x]);
			}
		

		}
	}
}
