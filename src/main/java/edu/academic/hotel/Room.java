package edu.academic.hotel;
import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity @Table(name="rooms", uniqueConstraints=@UniqueConstraint(columnNames="roomNumber"))
public class Room {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id;
 @Column(nullable=false,unique=true) public String roomNumber;
 @Column(nullable=false) public String roomType;
 @Column(nullable=false,length=1200) public String description;
 @Column(nullable=false) public int capacity;
 @Column(nullable=false,precision=10,scale=2) public BigDecimal pricePerNight;
 public String imageUrl;
 @Column(length=500) public String amenities;
 @Column(nullable=false) public boolean active=true;
 protected Room(){}
 public Room(String number,String type,String description,int capacity,String price,String image,String amenities){this.roomNumber=number;this.roomType=type;this.description=description;this.capacity=capacity;this.pricePerNight=new BigDecimal(price);this.imageUrl=image;this.amenities=amenities;}
}
