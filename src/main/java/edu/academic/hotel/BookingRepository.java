package edu.academic.hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface BookingRepository extends JpaRepository<Booking,Long> { Optional<Booking> findByBookingReference(String reference); List<Booking> findAllByOrderByCreatedAtDesc(); }
