package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
	
	public List<Instructor> findAll();
	public Instructor findByInstructorID(Long InstructorID);
	public void deleteByInstructorID(Long InstructorID);
	
	

}

//List<Instructor> findAll();
//This method finds all instructors in the repository.
//Instructor findByInstructorID(Long instructorID);
//This method finds a specific instructor based on the given ID.
//void deleteByInstructorID(Long instructorID);
//This method deletes an instructor recorded in the repository based on a given ID.

