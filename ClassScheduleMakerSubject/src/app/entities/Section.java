package app.entities;

<<<<<<< Updated upstream
=======
import java.util.Set;
>>>>>>> Stashed changes

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
<<<<<<< Updated upstream
=======
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
>>>>>>> Stashed changes
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Section {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
<<<<<<< Updated upstream
    private Long pk;
=======
    private Long sectionPk;
>>>>>>> Stashed changes

	@Column
	@NotNull
    private String sectionName;
	
<<<<<<< Updated upstream
	@NotNull
	@ManyToOne
	@JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
=======
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
    private Long slots;
	
	@ManyToOne
    @JoinColumn(name = "subject_pk")
    private Subject subject;
	
	@ManyToOne
    @JoinColumn(name = "room_pk")
    private Room room;
	
	@ManyToMany
    @JoinTable(name = "instructor",
            joinColumns = @JoinColumn(name = "section_pk"),
            inverseJoinColumns = @JoinColumn(name = "instructor_pk"))
    private Set<Instructor> instructors;

	public Long getSectionPk() {
		return sectionPk;
	}

	public void setSectionPk(Long sectionPk) {
		this.sectionPk = sectionPk;
>>>>>>> Stashed changes
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

<<<<<<< Updated upstream
=======
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

	public Long getSlots() {
		return slots;
	}

	public void setSlots(Long slots) {
		this.slots = slots;
	}

>>>>>>> Stashed changes
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

<<<<<<< Updated upstream
	@Override
	public String toString() {
		return "Section [pk=" + pk + ", sectionName=" + sectionName + ", subject=" + subject + "]";
	}
	
	
=======
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Set<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(Set<Instructor> instructors) {
		this.instructors = instructors;
	}

	@Override
	public String toString() {
		return "Section [sectionPk=" + sectionPk + ", sectionName=" + sectionName + ", dayOfTheWeekSchedule="
				+ dayOfTheWeekSchedule + ", timeStart=" + timeStart + ", timeEnd=" + timeEnd + ", slots=" + slots
				+ ", subject=" + subject + ", room=" + room + ", instructors=" + instructors + "]";
	}
>>>>>>> Stashed changes
}
