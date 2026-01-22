package com.xyz.moviebooking.repository;

import com.xyz.moviebooking.persistence.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
}
