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
    private Long instructorID;
	
	@Column
	@NotNull
    private String name;
	
	@Column
	@NotNull
    private String courseHandled;

	public Long getPk() {
		return instructorID;
	}

	public void setPk(Long pk) {
		this.instructorID = pk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
	


}
