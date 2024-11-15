package app.entities;


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
    private Long roomPk;

	@Column
	@NotNull
    private String roomNumber;

	public Long getRoomPk() {
		return roomPk;
	}

	public void setRoomPk(Long roomPk) {
		this.roomPk = roomPk;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	@Override
	public String toString() {
		return "Room [roomPk=" + roomPk + ", roomNumber=" + roomNumber + "]";
	}
}
