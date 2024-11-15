package app.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import app.entities.Instructor;
import app.repositories.InstructorRepository;
<<<<<<< Updated upstream
import app.repositories.SubjectRepository;
=======
>>>>>>> Stashed changes

@Component
public class InstructorComponent {
	
	@Autowired
   	private InstructorRepository instructRepo;
	
<<<<<<< Updated upstream
	@Autowired
	private SubjectComponent sc;
	
=======
	@Transactional
>>>>>>> Stashed changes
	public List<Instructor> findInstructorAll(){
		return this.instructRepo.findAll();
	}
	
<<<<<<< Updated upstream
=======
	@Transactional
>>>>>>> Stashed changes
	public Instructor findInstructor(Long pk) {
		return this.instructRepo.findByInstructorID(pk);
	}

<<<<<<< Updated upstream
    public Instructor addInstructor(String name, String courseHandled) throws Exception{
   
  
   if(name != null && courseHandled != null) {
	   if (!sc.subjectExistsByCode(courseHandled)) {
           throw new IllegalArgumentException("A Subject with that SubjectCode does not exist: " + courseHandled);
       }
   		else {
   		Instructor newInstructor = new Instructor();
        	newInstructor.setName(name);
        	newInstructor.setCourseHandled(courseHandled);
        	return instructRepo.save(newInstructor);	
   		}
   }
   else {
       throw new IllegalArgumentException("Please fill-up all the blank parameters with VALID INPUTS.");

   }
    	
    	
    	
       
    }
	
    public Instructor updateInstructor(Long pk, String name, String courseHandled) throws Exception {
=======
	@Transactional
    public Instructor addInstructor(String name) throws Exception{
   
   		Instructor newInstructor = new Instructor();
        newInstructor.setName(name);
        return instructRepo.save(newInstructor);
    }
	
    public Instructor updateInstructor(Long pk, String name) throws Exception {
>>>>>>> Stashed changes
    	
    	Instructor existingInstructor = instructRepo.findByInstructorID(pk);
        
    	//Basically, it only updates values with non-empty parameters <3
    	
<<<<<<< Updated upstream
	        if (existingInstructor != null) {
	        	
	        	 if (name != null && !name.isEmpty()) {
	                 existingInstructor.setName(name);
	        	 }
	        	 
	        	 if (courseHandled != null && !courseHandled.isEmpty()) {
	        		 if (!sc.subjectExistsByCode(courseHandled)) {
	        	           throw new IllegalArgumentException("A Subject with that SubjectCode does not exist: " + courseHandled);
	        	       }
	        		 else {
		                existingInstructor.setCourseHandled(courseHandled);
	 
	        		 }
	        	 }
	            
	            return instructRepo.save(existingInstructor);
	        } else {
	        	
	        	
	            throw new IllegalArgumentException("Instructor with pk: " + pk + " not found. Check if pk parameter is NULL or INVALID.");
	            
	        }
=======
	        if (existingInstructor == null) {
	        	throw new IllegalArgumentException("Instructor with pk: " + pk + " not found. Check if pk parameter is NULL or INVALID.");	            
	        }
	        
            existingInstructor.setName(name);
	        return instructRepo.save(existingInstructor);
>>>>>>> Stashed changes
    }
			

    @Transactional
    public String deleteInstructor(Long pk) {
        Instructor existingInstructor = instructRepo.findByInstructorID(pk);
        
        if (existingInstructor != null) {
        	instructRepo.deleteByInstructorID(pk);
            return "Instructor with pk: " + pk + " has been deleted successfully.";
        } else {
            return "No Instructor has been deleted.";

        }
        
    }
	


}
