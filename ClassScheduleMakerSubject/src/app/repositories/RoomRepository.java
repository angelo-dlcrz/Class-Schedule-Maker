package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
	
	public List<Room> findAll();
	public Room findByRoomPk(Long roomPk);
	public void deleteByRoomPk(Long roomPk);
	public Room findByRoomNumber (String roomNumber);
	
	

}
//
//List<Room> findAll();
//This method finds all room instances recorded in the repository.
//Room findByRoomID(Long roomID);
//This method finds a specific room based on the given room ID.
//void deleteByRoomID(Long roomID);
//This method deletes a room recorded in the repository based on a given ID.
//
