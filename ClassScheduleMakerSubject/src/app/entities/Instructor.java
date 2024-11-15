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
    private Long instructorPk;
	
	@Column
	@NotNull
    private String name;

	public Long getInstructorPk() {
		return instructorPk;
	}

	public void setInstructorPk(Long instructorPk) {
		this.instructorPk = instructorPk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Instructor [instructorPk=" + instructorPk + ", name=" + name + "]";
	}
}
