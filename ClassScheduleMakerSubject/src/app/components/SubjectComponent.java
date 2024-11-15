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
	
	@Transactional
	public List<Subject> findSubjectAll(){
		return this.subjRepo.findAll();
	}
	
	@Transactional

	public Subject findSubject(Long pk) {
		return this.subjRepo.findBySubjectPk(pk);
	}

	@Transactional
    public Subject addSubject(String subjectCode, String category, String name, String department, 
                              String departmentRestrictions) {
    	
    	if (subjectExistsByCode(subjectCode)) {
	           throw new IllegalArgumentException("Cannot add new subject with same Subject Code: " + subjectCode);
	       }
		 else {
			 Subject newSubject = new Subject();
	        	newSubject.setSubjectCode(subjectCode);
		        newSubject.setCategory(category);
		        newSubject.setName(name);
//		        newSubject.setDayOfTheWeekSchedule(dayOfTheWeek);
//		        newSubject.setTimeStart(timeStart);
//		        newSubject.setTimeEnd(timeEnd);
		        newSubject.setDepartment(department);
		        newSubject.setDepartmentRestrictions(departmentRestrictions);
//		        newSubject.setSlots(slots);
	        return subjRepo.save(newSubject);

		 }
    	
        
    }
	
    public Subject updateSubject(Long pk, String subjectCode, String category, String name, String department, 
            String departmentRestrictions) throws Exception {
    	
    	Subject existingSubject = subjRepo.findBySubjectPk(pk);
        
    	//Basically, it only updates values with non-empty parameters <3
//    	
    			if(existingSubject!=null) {
    				existingSubject.setSubjectCode(subjectCode);
    				existingSubject.setCategory(category);
    				existingSubject.setDepartment(department);
    				existingSubject.setDepartmentRestrictions(departmentRestrictions);
    				return subjRepo.save(existingSubject);
    			}
//    	
//    		   if (existingSubject != null) {
//   	    
//  	        	 if (subjectCode != null && !subjectCode.isEmpty()) {
//  	                 existingSubject.setSubjectCode(subjectCode);
//  	             }
//  	        	 if (category != null && !category.isEmpty()) {
//  	                 existingSubject.setCategory(category);
//  	             }
//  	             if (name != null && !name.isEmpty()) {
//  	                 existingSubject.setName(name);
//  	             }
//  	             if (dayOfTheWeek != null && !dayOfTheWeek.isEmpty()) {
//  	                 existingSubject.setDayOfTheWeekSchedule(dayOfTheWeek);
//  	             }
//  	             if (timeStart != null && !timeStart.isEmpty()) {
//  	                 existingSubject.setTimeStart(timeStart);
//  	             }
//  	             if (timeEnd != null && !timeEnd.isEmpty()) {
//  	                 existingSubject.setTimeEnd(timeEnd);
//  	             }
//  	             if (department != null && !department.isEmpty()) {
//  	                 existingSubject.setDepartment(department);
//  	             }
//  	             if (departmentRestrictions != null && !departmentRestrictions.isEmpty()) {
//  	                 existingSubject.setDepartmentRestrictions(departmentRestrictions);
//  	             }
//  	             if (slots > 0) { // Assuming slots cannot be negative; adjust as needed for default behavior
//  	                 existingSubject.setSlots(slots);
//  	             }
//  	            
//  	            return subjRepo.save(existingSubject);
  	        	        	
  	            throw new IllegalArgumentException("Subject with pk: " + pk + " not found. Check if pk parameter is NULL or INVALID.");
  	            
    		
    	}
	     
    
			

    @Transactional
    public String deleteSubject(Long pk) {
        Subject existingSubject = subjRepo.findBySubjectPk(pk);
        
        if (existingSubject != null) {
            subjRepo.deleteBySubjectPk(pk);
            return "Subject with pk: " + pk + " has been deleted successfully.";
        } else {
            return "No subject has been deleted.";

        }
        
    }
    
    
    public boolean subjectExistsByCode(String subjectCode) {
        return subjRepo.findBySubjectCode(subjectCode) != null;
    } 
	


}
