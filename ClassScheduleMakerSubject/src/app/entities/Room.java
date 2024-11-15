package app.entities;

<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Room {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
<<<<<<< Updated upstream
    private Long roomID;
=======
    private Long roomPk;
>>>>>>> Stashed changes

	@Column
	@NotNull
    private String roomNumber;

<<<<<<< Updated upstream
	public Long getRoomID() {
		return roomID;
	}

	public void setRoomID(Long roomID) {
		this.roomID = roomID;
=======
	public Long getRoomPk() {
		return roomPk;
	}

	public void setRoomPk(Long roomPk) {
		this.roomPk = roomPk;
>>>>>>> Stashed changes
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
<<<<<<< Updated upstream
	

=======

	@Override
	public String toString() {
		return "Room [roomPk=" + roomPk + ", roomNumber=" + roomNumber + "]";
	}
>>>>>>> Stashed changes
}
