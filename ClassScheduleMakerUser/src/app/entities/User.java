package app.entities;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.validation.constraints.NotNull;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long userPk;
	
	@Column
	@NotNull
	private String name;
	
	@Column
	@NotNull
	private String course;
	
	@Column
	@NotNull
	private String phoneNumber;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sectionPk", nullable = true)
    private Set<Section> sections = new HashSet<>();


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Long getUserPk() {
		return userPk;
	}

	public void setUserPk(Long userPk) {
		this.userPk = userPk;
	}

	public Set<Section> getSections() {
		return sections;
	}

	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}

	@Override
	public String toString() {
		return "User [userPk=" + userPk + ", name=" + name + ", course=" + course + ", phoneNumber=" + phoneNumber
				+ ", sections=" + sections + "]";
	}
	
	
	
}
