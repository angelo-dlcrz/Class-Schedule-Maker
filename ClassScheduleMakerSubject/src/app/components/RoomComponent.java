package app.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import app.entities.Room;
import app.repositories.RoomRepository;

@Component
public class RoomComponent {
	
	@Autowired
   	private RoomRepository roomRepo;
	
	public List<Room> findRoomAll(){
		return this.roomRepo.findAll();
	}
	
	public Room findRoom(Long pk) {
		return this.roomRepo.findByRoomID(pk);
	}

    public Room addRoom(String roomNumber) {
        Room newRoom = new Room();
        	newRoom.setRoomNumber(roomNumber);
        return roomRepo.save(newRoom);
    }
	
    public Room updateRoom(Long pk, String roomNumber) throws Exception {
    	
    	Room existingRoom = roomRepo.findByRoomID(pk);
        
    	//Basically, it only updates values with non-empty parameters <3
    	
	        if (existingRoom != null) {
	        	
	        	 if (roomNumber != null && !roomNumber.isEmpty()) {
	                 existingRoom.setRoomNumber(roomNumber);
	        	 }
	            
	            return roomRepo.save(existingRoom);
	        } else {
	        	
	        	
	            throw new IllegalArgumentException("Room with pk: " + pk + " not found. Check if pk parameter is NULL or INVALID.");
	            
	        }
    }
			

    @Transactional
    public String deleteRoom(Long pk) {
        Room existingRoom = roomRepo.findByRoomID(pk);
        
        if (existingRoom != null) {
        	roomRepo.deleteByRoomID(pk);
            return "Room with pk: " + pk + " has been deleted successfully.";
        } else {
            return "No Room has been deleted.";

        }
        
    }
	


}
