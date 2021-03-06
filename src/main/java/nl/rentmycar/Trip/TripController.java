package nl.rentmycar.Trip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/trip") //baseline for all trip endpoints. Always start with /trip followed by the path of the endpoint.
public class TripController {

    @Autowired
    private ITripService tripService;   //Auto wiring handles the initialization of the TripService class.

    @GetMapping()
    public List<Trip> findAll() {
        return tripService.findAll();
    }

    @GetMapping(path = "/car/{id}")
    public List<Trip> findByUser_Id(@PathVariable long id) {
        return tripService.findByUser_Id(id);
    }

    @GetMapping(path = "/person/{id}")
    public List<Trip> findByCar_Id(@PathVariable long id) {
        return tripService.findByCar_Id(id);
    }

    @GetMapping(path = "/{id}")
    public Optional<Trip> findById(@PathVariable long id) {
        return tripService.findById(id);
    }

    @PostMapping(path = "/plan")
    public Trip planTrip(@Valid @RequestBody Trip trip) {
        return tripService.planTrip(trip);
    }

    @PostMapping(path = "/location")
    public void saveLocation(@Valid @RequestBody Trip trip) {
        tripService.saveLocation(trip);
    }

    @PostMapping(path = "/acceleration")
    public boolean saveAcceleration(@Valid @RequestBody Trip trip){
        return tripService.saveAcceleration(trip);
    }
}