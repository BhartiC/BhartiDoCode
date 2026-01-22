package com.xyz.moviebooking.repository;

import com.xyz.moviebooking.persistence.SeatEntity;
import java.util.List;
import javax.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SeatRepository extends JpaRepository<SeatEntity, Long> {
    @Query("select s from SeatEntity s where s.showtimeId = :showtimeId and s.seatNumber in :seatNumbers")
    List<SeatEntity> findSeatsForUpdate(@Param("showtimeId") String showtimeId,
                                        @Param("seatNumbers") List<String> seatNumbers);

    long countByShowtimeId(String showtimeId);
}
