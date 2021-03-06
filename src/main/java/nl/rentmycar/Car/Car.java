package nl.rentmycar.Car;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import nl.rentmycar.Trip.Trip;
import nl.rentmycar.User.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //automatically generates value
    @Column(name = "id", nullable = false)
    private Long id;
    private String brand;
    private String image;
    private String brandModel;
    private Integer kmDriven;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Integer carRange;
    private Double TCO;
    private Double startRate;
    private Double kmRate;

    @JsonBackReference(value = "user-car") ////Ensures no recursions happen when retrieving a User.
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JsonManagedReference(value = "car-trip") //Ensures no recursions happen when retrieving a Car.
    @OneToMany(fetch = FetchType.LAZY, targetEntity = Trip.class, cascade = CascadeType.ALL, mappedBy = "car")
    public List<Trip> trips;


    public Car(String brand,
               String image,
               String brandModel,
               Integer kmDriven,
               LocalDateTime startDateTime,
               LocalDateTime endDateTime,
               Integer carRange,
               Double TCO) {
        this.brand = brand;
        this.image = image;
        this.brandModel = brandModel;
        this.kmDriven = kmDriven;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.carRange = carRange;
        this.TCO = TCO;
        this.trips = new ArrayList<>();
    }

    public Car() {
        this.trips = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBrandModel() {
        return brandModel;
    }

    public void setBrandModel(String brandModel) {
        this.brandModel = brandModel;
    }

    public Integer getKmDriven() {
        return kmDriven;
    }

    public void setKmDriven(Integer kmDriven) {
        this.kmDriven = kmDriven;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Integer getCarRange() {
        return carRange;
    }

    public void setCarRange(Integer carRange) {
        this.carRange = carRange;
    }

    public Double getTCO() {
        return TCO;
    }

    public void setTCO(Double TCO) {
        this.TCO = TCO;
    }

    public void addTrip(Trip trip) {
        trip.setCar(this);
        this.trips.add(trip);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public Double getStartRate() {
        return startRate;
    }

    public void setStartRate(Double startRate) {
        this.startRate = startRate;
    }

    public Double getKmRate() {
        return kmRate;
    }

    public void setKmRate(Double kmRate) {
        this.kmRate = kmRate;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }
}


