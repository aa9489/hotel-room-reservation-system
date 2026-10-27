package edu.academic.hotel;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import jakarta.persistence.LockModeType;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
public interface RoomRepository extends JpaRepository<Room,Long> {
 @Lock(LockModeType.PESSIMISTIC_WRITE) @Query("select r from Room r where r.id=:id") Optional<Room> lockById(@Param("id") Long id);
 @Query("select r from Room r where r.active=true and r.capacity>=:guests and (:type is null or lower(r.roomType)=lower(:type)) and (:maxPrice is null or r.pricePerNight<=:maxPrice) and not exists (select b from Booking b where b.room=r and b.bookingStatus=edu.academic.hotel.BookingStatus.CONFIRMED and b.checkInDate<:outDate and b.checkOutDate>:inDate)")
 List<Room> findAvailable(@Param("inDate") LocalDate inDate,@Param("outDate") LocalDate outDate,@Param("guests") int guests,@Param("type") String type,@Param("maxPrice") BigDecimal maxPrice);
}
