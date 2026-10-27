package edu.academic.hotel;
import org.springframework.http.*; import org.springframework.web.bind.MethodArgumentNotValidException; import org.springframework.web.bind.annotation.*; import org.springframework.web.server.ResponseStatusException; import java.util.*;
@RestControllerAdvice public class ApiErrors {
 @ExceptionHandler(ResponseStatusException.class) ResponseEntity<Map<String,Object>> status(ResponseStatusException e){return ResponseEntity.status(e.getStatusCode()).body(Map.of("status",e.getStatusCode().value(),"error",HttpStatus.valueOf(e.getStatusCode().value()).getReasonPhrase(),"message",Objects.toString(e.getReason(),"Request failed")));}
 @ExceptionHandler(MethodArgumentNotValidException.class) ResponseEntity<Map<String,Object>> validation(MethodArgumentNotValidException e){String message=e.getBindingResult().getFieldErrors().stream().map(x->x.getField()+": "+x.getDefaultMessage()).findFirst().orElse("Request validation failed");return ResponseEntity.badRequest().body(Map.of("status",400,"error","Bad Request","message",message));}
 @ExceptionHandler(Exception.class) ResponseEntity<Map<String,Object>> other(Exception e){return ResponseEntity.internalServerError().body(Map.of("status",500,"error","Internal Server Error","message","The request could not be completed"));}
}
