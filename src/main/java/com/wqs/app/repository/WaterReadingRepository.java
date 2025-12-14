package com.wqs.app.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wqs.app.entity.WaterReading;

public interface WaterReadingRepository extends JpaRepository<WaterReading, Long> {
	 List<WaterReading> findByLocation(String location);
	 
	 List<WaterReading> findByTimestampBetween(
		        LocalDateTime start,
		        LocalDateTime end
		    );
	 
	 Optional<WaterReading> findTopByOrderByTimestampDesc();
	 
	 long countByQuality(String quality);
	 
	 @Query("SELECT AVG(w.ph) FROM WaterReading w")
	 Double avgPh();

	 @Query("SELECT AVG(w.turbidity) FROM WaterReading w")
	 Double avgTurbidity();

	 @Query("SELECT AVG(w.tds) FROM WaterReading w")
	 Double avgTds();

	 @Query("SELECT AVG(w.temperature) FROM WaterReading w")
	 Double avgTemperature();
	 
	 List<WaterReading> findAllByOrderByTimestampAsc();

}
