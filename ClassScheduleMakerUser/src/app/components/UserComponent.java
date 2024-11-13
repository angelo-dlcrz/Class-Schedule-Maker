package app.components;

import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.User;
import app.repositories.UserRepository;

@Component
public class UserComponent {
	@Autowired
	private UserRepository repo;
	
	public List<User> getAllUsers() {
		 return repo.findAll();
	}
	
	public User findUser(Long studentID) {
		return repo.findByStudentID(studentID);
	}
	
	public User createUser(String name, String course, String phoneNumber) {
		User u1 = new User();
		u1.setName(name);
		u1.setCourse(course);
		u1.setPhoneNumber(phoneNumber);
		return repo.save(u1);
	}
	
	
	public User updateUser(Long studentID, String name, String course, String phoneNumber) {
		User u1 = repo.findByStudentID(studentID);
		if (u1 == null) {
	        throw new RuntimeException("User not found");
	    }
		u1.setName(name);
		u1.setCourse(course);
		u1.setPhoneNumber(phoneNumber);
		return repo.save(u1);
	}
	
	public void deleteUser(Long studentID) {
		if(repo.findByStudentID(studentID) == null) {
			throw new RuntimeException("User not found");
		}
		repo.deleteById(studentID);
	}
	
}
