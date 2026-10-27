package edu.academic.hotel;
import jakarta.validation.Valid; import java.math.BigDecimal; import java.time.LocalDate; import java.util.List;
import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api") public class ApiController {
 private final ReservationService service; private final CustomerRepository customers;
 public ApiController(ReservationService s,CustomerRepository c){service=s;customers=c;}
 @GetMapping("/rooms") public List<RoomView> rooms(@RequestParam(required=false) String type,@RequestParam(required=false) BigDecimal maxPrice){return service.listRooms(type,maxPrice);}
 @GetMapping("/rooms/available") public List<RoomView> available(@RequestParam LocalDate checkIn,@RequestParam LocalDate checkOut,@RequestParam(defaultValue="1") int guests,@RequestParam(required=false) String type){return service.available(checkIn,checkOut,guests,type);}
 @GetMapping("/rooms/{id}") public RoomView room(@PathVariable Long id){return service.room(id);}
 @PostMapping("/customers") @ResponseStatus(HttpStatus.CREATED) public CustomerView createCustomer(@Valid @RequestBody CustomerRequest request){return service.createCustomer(request);}
 @GetMapping("/customers/{id}") public CustomerView customer(@PathVariable Long id){return service.customer(id);}
 @PostMapping("/bookings") @ResponseStatus(HttpStatus.CREATED) public BookingView book(@Valid @RequestBody BookingRequest request){return service.book(request);}
 @GetMapping("/bookings") public List<BookingView> bookings(){return service.all();}
 @GetMapping("/bookings/{reference}") public BookingView booking(@PathVariable String reference){return service.booking(reference);}
 @PatchMapping("/bookings/{reference}/cancel") public BookingView cancel(@PathVariable String reference){return service.cancel(reference);}
 @PatchMapping("/bookings/{reference}/status") public BookingView status(@PathVariable String reference,@Valid @RequestBody StatusRequest request){return service.status(reference,request.status());}
}
