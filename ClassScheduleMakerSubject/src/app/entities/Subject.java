package app.entities;

<<<<<<< Updated upstream

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
>>>>>>> Stashed changes
import javax.validation.constraints.NotNull;

@Entity
public class Subject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
<<<<<<< Updated upstream
    private Long pk;
=======
    private Long subjectPk;
>>>>>>> Stashed changes

	@Column
	@NotNull
    private String subjectCode;
<<<<<<< Updated upstream
	//example CSCI41
=======
>>>>>>> Stashed changes
	
	@Column
	@NotNull
    private String category;
<<<<<<< Updated upstream
	//Major
=======
>>>>>>> Stashed changes

	@Column
	@NotNull
    private String name;
<<<<<<< Updated upstream
	//Introduction to Dying

	@Column
	@NotNull
    private String dayOfTheWeekSchedule;

	@Column
	@NotNull
    private String timeStart;

	@Column
	@NotNull
    private String timeEnd;
=======
>>>>>>> Stashed changes

	@Column
	@NotNull
    private String department;

	@Column
    private String departmentRestrictions;

<<<<<<< Updated upstream
	@Column
	@NotNull
    private Integer slots;
	
	@ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
	@MapKeyColumn(name = "pk")
	@Column(name = "section")
	private Map<Long, String> sections = new HashMap<>();

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
=======
	public Long getSubjectPk() {
		return subjectPk;
	}

	public void setSubjectPk(Long subjectPk) {
		this.subjectPk = subjectPk;
>>>>>>> Stashed changes
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

<<<<<<< Updated upstream
	public String getDayOfTheWeekSchedule() {
		return dayOfTheWeekSchedule;
	}

	public void setDayOfTheWeekSchedule(String dayOfTheWeekSchedule) {
		this.dayOfTheWeekSchedule = dayOfTheWeekSchedule;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

=======
>>>>>>> Stashed changes
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDepartmentRestrictions() {
		return departmentRestrictions;
	}

	public void setDepartmentRestrictions(String departmentRestrictions) {
		this.departmentRestrictions = departmentRestrictions;
	}

<<<<<<< Updated upstream
	public Integer getSlots() {
		return slots;
	}

	public void setSlots(Integer slots) {
		this.slots = slots;
	}

	public Map<Long, String> getSections() {
		return sections;
	}

	public void setSections(Map<Long, String> sections) {
		this.sections = sections;
	}

	@Override
	public String toString() {
		return "Subject [pk=" + pk + ", subjectCode=" + subjectCode + ", category=" + category + ", name=" + name
				+ ", dayOfTheWeekSchedule=" + dayOfTheWeekSchedule + ", timeStart=" + timeStart + ", timeEnd=" + timeEnd
				+ ", department=" + department + ", departmentRestrictions=" + departmentRestrictions + ", slots="
				+ slots + ", sections=" + sections + "]";
	}


	
	

	
=======
	@Override
	public String toString() {
		return "Subject [subjectPk=" + subjectPk + ", subjectCode=" + subjectCode + ", category=" + category + ", name="
				+ name + ", department=" + department + ", departmentRestrictions=" + departmentRestrictions + "]";
	}
>>>>>>> Stashed changes
}