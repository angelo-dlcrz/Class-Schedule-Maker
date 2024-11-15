package app.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import app.entities.Instructor;
import app.entities.Room;
import app.entities.Section;
import app.entities.Subject;
import app.repositories.InstructorRepository;
import app.repositories.RoomRepository;
import app.repositories.SectionRepository;
import app.repositories.SubjectRepository;

@Component
public class SectionComponent {
	
	@Autowired
   	private SectionRepository repo;
	
	@Autowired
   	private SubjectRepository subrepo;
	
	@Autowired
   	private InstructorRepository insrepo;
	
	@Autowired
   	private RoomRepository roomrepo;
	
	@Transactional
	public List<Section> getAllSections(){
		return this.repo.findAll();
	}
	@Transactional
	public Section findSection(Long pk) {
		return this.repo.findBySectionPk(pk);
	}
	
	@Transactional
	public Section createSection(String name, String dayOfTheWeekSchedule, String timeStart, String timeEnd, int slots, String subjectCode, String roomName, String instructor) {
		Subject s1 = subrepo.findBySubjectCode(subjectCode);
		Instructor ins = insrepo.findByName(instructor);
		Room rm = roomrepo.findByRoomNumber(roomName);

		Section sect = repo.findBySectionName(name);
		
		if(s1==null) {
			throw new RuntimeException("Subject not found");
		}
		
		if(sect != null && sect.getSubject() == s1) {
			throw new RuntimeException("Section already exists.");
		}
		
		Section s = new Section();
		s.setSectionName(name);
		s.setDayOfTheWeekSchedule(dayOfTheWeekSchedule);
		s.setTimeStart(timeStart);
		s.setTimeEnd(timeEnd);
		s.setSlots(slots);
		s.setSubject(s1);
		s.setRoom(rm);
		s.getInstructors().add(ins);
		return repo.save(s);
		
		
	}


	@Transactional
	public Section updateSection(Long pk, String name, String dayOfTheWeekSchedule, String timeStart, String timeEnd, int slots, String subjectCode, String roomName, String instructor) {
		
		Section s = repo.findBySectionPk(pk);
		Subject s1 = subrepo.findBySubjectCode(subjectCode);
		Instructor ins = insrepo.findByName(instructor);
		Room rm = roomrepo.findByRoomNumber(roomName);

		Section sect = repo.findBySectionName(name);
		
		if(s1==null) {
			throw new RuntimeException("Subject not found");
		}
		
		if(sect != null && sect.getSubject() == s1) {
			throw new RuntimeException("Section already exists.");
		}
		
		s.setSectionName(name);
		s.setDayOfTheWeekSchedule(dayOfTheWeekSchedule);
		s.setTimeStart(timeStart);
		s.setTimeEnd(timeEnd);
		s.setSlots(slots);
		s.setSubject(s1);
		s.setRoom(rm);
		s.getInstructors().add(ins);
		return repo.save(s);
		
		
	}
	
	@Transactional
	public String deleteSection(Long pk) {
		if(repo.findBySectionPk(pk) == null) {
			return "No section found";
		}
		repo.deleteById(pk);
		return "Section successfully deleted";
	}

}
