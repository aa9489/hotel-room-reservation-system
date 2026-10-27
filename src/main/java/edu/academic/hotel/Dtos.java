package edu.academic.hotel;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.math.BigDecimal;
record CustomerRequest(@NotBlank String fullName,@NotBlank @Email String email,@NotBlank String phoneNumber) {}
record BookingRequest(@NotNull Long roomId,@NotBlank String fullName,@NotBlank @Email String email,@NotBlank String phoneNumber,@NotNull LocalDate checkInDate,@NotNull LocalDate checkOutDate,@Min(1) int numberOfGuests) {}
record StatusRequest(@NotNull BookingStatus status) {}
record CustomerView(Long id,String fullName,String email,String phoneNumber) {}
record RoomView(Long id,String roomNumber,String roomType,String description,int capacity,BigDecimal pricePerNight,String imageUrl,ListString amenities,boolean active) {}
record ListString(java.util.List<String> values) {}
record BookingView(Long id,String bookingReference,CustomerView customer,RoomView room,LocalDate checkInDate,LocalDate checkOutDate,int numberOfGuests,BigDecimal totalPrice,BookingStatus bookingStatus,java.time.Instant createdAt,java.time.Instant updatedAt) {}
