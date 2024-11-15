package app.repositories;

import org.springframework.stereotype.Repository;

import app.entities.Section;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {

	public List<Section> findAll();
	public Section findBySectionPk(Long sectionPk);
	public void deleteBySectionPk(Long sectionPk);
	public Section findBySectionName(String sectionName);
	
}


//List<Subject> findAll();
//This method gets all the subject entities in the repository.
//Subject findByPk(Long pk);
//This method finds a specific subject based on the given key.
//void deleteByPk(Long pk);
//This method deletes a subject instance based on a given primary key.
