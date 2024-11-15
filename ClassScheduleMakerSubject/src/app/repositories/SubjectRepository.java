package app.repositories;

import org.springframework.stereotype.Repository;

import app.entities.Subject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

	public List<Subject> findAll();
	public Subject findBySubjectPk(Long subjectPk);
	public void deleteBySubjectPk(Long subjectPk);
	public Subject findBySubjectCode(String subjectCode);
	
}


//List<Subject> findAll();
//This method gets all the subject entities in the repository.
//Subject findByPk(Long pk);
//This method finds a specific subject based on the given key.
//void deleteByPk(Long pk);
//This method deletes a subject instance based on a given primary key.
