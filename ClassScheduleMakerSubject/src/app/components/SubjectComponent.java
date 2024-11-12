package app.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import app.entities.Subject;
import app.repositories.SubjectRepository;

@Component
public class SubjectComponent {
	
	@Autowired
   	private SubjectRepository subjRepo;
	
	public List<Subject> findSubjectAll(){
		return this.subjRepo.findAll();
	}
	
	public Subject findSubject(Long pk) {
		return this.subjRepo.findByPk(pk);
	}

    public Subject addSubject(String subjectCode, String category, String name, String dayOfTheWeek, 
                              String timeStart, String timeEnd, String department, 
                              String departmentRestrictions, int slots) {
    	
    	if (subjectExistsByCode(subjectCode)) {
	           throw new IllegalArgumentException("Cannot add new subject with same Subject Code: " + subjectCode);
	       }
		 else {
			 Subject newSubject = new Subject();
	        	newSubject.setSubjectCode(subjectCode);
		        newSubject.setCategory(category);
		        newSubject.setName(name);
		        newSubject.setDayOfTheWeekSchedule(dayOfTheWeek);
		        newSubject.setTimeStart(timeStart);
		        newSubject.setTimeEnd(timeEnd);
		        newSubject.setDepartment(department);
		        newSubject.setDepartmentRestrictions(departmentRestrictions);
		        newSubject.setSlots(slots);
	        return subjRepo.save(newSubject);

		 }
    	
        
    }
	
    public Subject updateSubject(Long pk, String subjectCode, String category, String name, String dayOfTheWeek, 
            String timeStart, String timeEnd, String department, 
            String departmentRestrictions, int slots) throws Exception {
    	
    	Subject existingSubject = subjRepo.findByPk(pk);
        
    	//Basically, it only updates values with non-empty parameters <3
    	
    
    	
    		   if (existingSubject != null) {
   	    
  	        	 if (subjectCode != null && !subjectCode.isEmpty()) {
  	                 existingSubject.setSubjectCode(subjectCode);
  	             }
  	        	 if (category != null && !category.isEmpty()) {
  	                 existingSubject.setCategory(category);
  	             }
  	             if (name != null && !name.isEmpty()) {
  	                 existingSubject.setName(name);
  	             }
  	             if (dayOfTheWeek != null && !dayOfTheWeek.isEmpty()) {
  	                 existingSubject.setDayOfTheWeekSchedule(dayOfTheWeek);
  	             }
  	             if (timeStart != null && !timeStart.isEmpty()) {
  	                 existingSubject.setTimeStart(timeStart);
  	             }
  	             if (timeEnd != null && !timeEnd.isEmpty()) {
  	                 existingSubject.setTimeEnd(timeEnd);
  	             }
  	             if (department != null && !department.isEmpty()) {
  	                 existingSubject.setDepartment(department);
  	             }
  	             if (departmentRestrictions != null && !departmentRestrictions.isEmpty()) {
  	                 existingSubject.setDepartmentRestrictions(departmentRestrictions);
  	             }
  	             if (slots > 0) { // Assuming slots cannot be negative; adjust as needed for default behavior
  	                 existingSubject.setSlots(slots);
  	             }
  	            
  	            return subjRepo.save(existingSubject);
  	        } else {
  	        	
  	        	
  	            throw new IllegalArgumentException("Subject with pk: " + pk + " not found. Check if pk parameter is NULL or INVALID.");
  	            
  	        }
    		
    	}
	     
    
			

    @Transactional
    public String deleteSubject(Long pk) {
        Subject existingSubject = subjRepo.findByPk(pk);
        
        if (existingSubject != null) {
            subjRepo.deleteByPk(pk);
            return "Subject with pk: " + pk + " has been deleted successfully.";
        } else {
            return "No subject has been deleted.";

        }
        
    }
    
    
    public boolean subjectExistsByCode(String subjectCode) {
        return subjRepo.findBySubjectCode(subjectCode) != null;
    } 
	


}
