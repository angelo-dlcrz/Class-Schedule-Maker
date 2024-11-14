package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.TimeSlot;


public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long>{
	List<TimeSlot> findAll();
	TimeSlot findByPk(Long pk);
	void deleteByPk(Long pk);
}
