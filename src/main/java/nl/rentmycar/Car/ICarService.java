package nl.rentmycar.Car;
import nl.rentmycar.Trip.Trip;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public interface ICarService {
    List<Car> findAll();

    Optional<Car> findById(long id);

    List<Car> findByBrandContaining(String brand);

    List<Car> findByAvailable(ArrayList<Trip> available);

    void saveCar(Car car);


    Iterable<Car> findByKmRateLessThanEqual(double kmrate);

    Iterable<Car> findByStartDateTimeLessThanEqualAndEndDateTimeGreaterThanEqual(Trip trip);  //This is where we started questioning our naming conventions.
}

