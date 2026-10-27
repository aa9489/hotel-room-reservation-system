package edu.academic.hotel;
import jakarta.persistence.*;
import java.time.Instant;
@Entity @Table(name="customers", uniqueConstraints=@UniqueConstraint(columnNames="email"))
public class Customer {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id;
 @Column(nullable=false) public String fullName;
 @Column(nullable=false, unique=true) public String email;
 @Column(nullable=false) public String phoneNumber;
 @Column(nullable=false) public Instant createdAt=Instant.now();
 protected Customer(){}
 public Customer(String name,String email,String phone){this.fullName=name;this.email=email.toLowerCase();this.phoneNumber=phone;}
}
