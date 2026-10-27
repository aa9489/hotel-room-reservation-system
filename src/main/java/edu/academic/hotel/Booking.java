package edu.academic.hotel;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.*;
@Entity @Table(name="bookings", indexes=@Index(columnList="bookingReference",unique=true))
public class Booking {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id;
 @Column(nullable=false,unique=true) public String bookingReference;
 @ManyToOne(optional=false,fetch=FetchType.LAZY) public Customer customer;
 @ManyToOne(optional=false,fetch=FetchType.LAZY) public Room room;
 @Column(nullable=false) public LocalDate checkInDate;
 @Column(nullable=false) public LocalDate checkOutDate;
 @Column(nullable=false) public int numberOfGuests;
 @Column(nullable=false,precision=10,scale=2) public BigDecimal totalPrice;
 @Enumerated(EnumType.STRING) @Column(nullable=false) public BookingStatus bookingStatus=BookingStatus.CONFIRMED;
 @Column(nullable=false) public Instant createdAt=Instant.now();
 @Column(nullable=false) public Instant updatedAt=Instant.now();
 protected Booking(){} public void bookingReference(String reference){this.bookingReference=reference;}
}

