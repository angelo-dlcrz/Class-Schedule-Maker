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
    private Long subjectPk;

	@Column
	@NotNull
    private String subjectCode;
	
	@Column
	@NotNull
    private String category;

	@Column
	@NotNull
    private String name;

	@Column
	@NotNull
    private String department;

	@Column
    private String departmentRestrictions;

	public Long getSubjectPk() {
		return subjectPk;
	}

	public void setSubjectPk(Long subjectPk) {
		this.subjectPk = subjectPk;
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

	@Override
	public String toString() {
		return "Subject [subjectPk=" + subjectPk + ", subjectCode=" + subjectCode + ", category=" + category + ", name="
				+ name + ", department=" + department + ", departmentRestrictions=" + departmentRestrictions + "]";
	}
}
