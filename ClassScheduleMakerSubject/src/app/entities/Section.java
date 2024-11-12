package app.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Section {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
    private Long pk;

	@Column
	@NotNull
    private String sectionName;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Section [pk=" + pk + ", sectionName=" + sectionName + ", subject=" + subject + "]";
	}
	
	
}
