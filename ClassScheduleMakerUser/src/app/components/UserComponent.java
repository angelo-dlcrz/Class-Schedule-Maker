package app.components;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.Section;
import app.entities.User;
import app.repositories.SectionRepository;
import app.repositories.UserRepository;

@Component
public class UserComponent {
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private SectionRepository section_repo;
	
	public List<User> getAllUsers() {
		 return repo.findAll();
	}
	
	public User findUser(Long studentID) {
		return repo.findByUserPk(studentID);
	}
	
	public User createUser(String name, String course, String phoneNumber) {
		User u1 = new User();
		u1.setName(name);
		u1.setCourse(course);
		u1.setPhoneNumber(phoneNumber);
		return repo.save(u1);
	}
	
	
	public User updateUser(Long studentID, String name, String course, String phoneNumber) {
		User u1 = repo.findByUserPk(studentID);
		if (u1 == null) {
	        throw new RuntimeException("User not found");
	    }
		u1.setName(name);
		u1.setCourse(course);
		u1.setPhoneNumber(phoneNumber);
		return repo.save(u1);
	}
	
	public String deleteUser(Long studentID) {
		if(repo.findByUserPk(studentID) == null) {
			return "User not found";
		}
		repo.deleteById(studentID);
		return "User deleted successfully";
	}
	
	public User addSection(Long studentID, Long sectionPk) {
		User u1 = repo.findByUserPk(studentID);
		Section s1 = section_repo.findBySectionPk(sectionPk);
		u1.getSections().add(s1);
		return repo.save(u1);
	}
	
	public User updateSection(Long studentID, Long oldSectionPk, Long newSectionPk) {
		User u1 = repo.findByUserPk(studentID);
		Section s1 = section_repo.findBySectionPk(newSectionPk);
		Iterator<Section> iterator = u1.getSections().iterator();
	    while (iterator.hasNext()) {
	        Section currentSection = iterator.next();
	        if (currentSection.getSectionPk().equals(oldSectionPk)) {
	            iterator.remove();
	            u1.getSections().add(s1);
	            break;
	        }
	    }

		return repo.save(u1);
	}

	
}
