package app.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import app.entities.Section;
import app.entities.Subject;
import app.repositories.SectionRepository;
import app.repositories.SubjectRepository;

@Component
public class SectionComponent {
	
	@Autowired
   	private SectionRepository repo;
	
	@Autowired
   	private SubjectRepository subrepo;
	
	public List<Section> getAllSections(){
		return this.repo.findAll();
	}
	
	public Section findSection(Long pk) {
		return this.repo.findByPk(pk);
	}
	
	public Section createSection(String sc, String name) {
		Subject s1 = subrepo.findBySubjectCode(sc);
		if(s1==null) {
			throw new RuntimeException("Subject not found");
		}
		for (String section : s1.getSections().values()) {
		    if (section.equals(name)) {
		    	throw new RuntimeException("Section already added");
		    }
		}
		Section s = new Section();
		s.setSectionName(name);
		s.setSubject(s1);
		repo.save(s);
		
		s1.getSections().put(s.getPk(), name);
		subrepo.save(s1);
		System.out.println(s1.getSections());
		return s;
	}
	
	public Section updateSection(Long pk, String sc, String name) {
		Section s = repo.findByPk(pk);
		Subject sub = subrepo.findBySubjectCode(sc);
		if (s == null) {
	        throw new RuntimeException("Section not found");
	    }
		if(!sub.getSections().containsKey(pk)) {
			throw new RuntimeException("Section not found in the given subject");
		}
		
		s.setSectionName(name);
		sub.getSections().put(pk, name);
		subrepo.save(sub);
		return repo.save(s);
	}
	
	@Transactional
	public String deleteSection(Long pk) {
		if(repo.findByPk(pk) == null) {
			return "No section found";
		}
		repo.deleteById(pk);
		return "Section successfully deleted";
	}

}
