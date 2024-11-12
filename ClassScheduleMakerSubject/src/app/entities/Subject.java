package app.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Subject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
    private Long pk;

	@Column
	@NotNull
    private String subjectCode;
	//example CSCI41
	
	@Column
	@NotNull
    private String category;
	//Major

	@Column
	@NotNull
    private String name;
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

	@Column
	@NotNull
    private String department;

	@Column
    private String departmentRestrictions;

	@Column
	@NotNull
    private Integer slots;

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
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

	public Integer getSlots() {
		return slots;
	}

	public void setSlots(Integer slots) {
		this.slots = slots;
	}

	@Override
	public String toString() {
		return "Subject [pk=" + pk + ", subjectCode=" + subjectCode + ", category=" + category + ", name=" + name
				+ ", dayOfTheWeekSchedule=" + dayOfTheWeekSchedule + ", timeStart=" + timeStart + ", timeEnd=" + timeEnd
				+ ", department=" + department + ", departmentRestrictions=" + departmentRestrictions + ", slots="
				+ slots + "]";
	}


	
	

	
}
