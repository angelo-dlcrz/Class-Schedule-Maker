package app.components;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.User;
import app.repositories.UserRepository;

@Component
public class UserInitializer {
	@Autowired
	private UserRepository userRepo;
	
	@PostConstruct
	public void init() {
		if(userRepo.count()==0) {
			
			User user[] = new User[1];
			for(int x = 0; x <= 0 ; x++) {
				user[x] = new User() ; //
				
			}
			
			
			user[0].setName("Jacob Cano");
			user[0].setCourse("BSCS");
			user[0].setPhoneNumber("09951234567");


			
			for(int x = 0; x <= 0; x++) {
				userRepo.save(user[x]);
			}
		

		}
	}
}
