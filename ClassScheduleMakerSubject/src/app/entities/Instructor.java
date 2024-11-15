package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Instructor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
<<<<<<< Updated upstream
    private Long instructorID;
=======
    private Long instructorPk;
>>>>>>> Stashed changes
	
	@Column
	@NotNull
    private String name;
<<<<<<< Updated upstream
	
	@Column
	@NotNull
    private String courseHandled;

	public Long getPk() {
		return instructorID;
	}

	public void setPk(Long pk) {
		this.instructorID = pk;
=======

	public Long getInstructorPk() {
		return instructorPk;
	}

	public void setInstructorPk(Long instructorPk) {
		this.instructorPk = instructorPk;
>>>>>>> Stashed changes
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

<<<<<<< Updated upstream
	public String getCourseHandled() {
		return courseHandled;
	}

	public void setCourseHandled(String courseHandled) {
		this.courseHandled = courseHandled;
	}

	@Override
	public String toString() {
		return "Instructor [pk=" + instructorID + ", name=" + name + ", courseHandled=" + courseHandled + "]";
	}
	


=======
	@Override
	public String toString() {
		return "Instructor [instructorPk=" + instructorPk + ", name=" + name + "]";
	}
>>>>>>> Stashed changes
}
