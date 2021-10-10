package nl.rentmycar.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "/car")
public class CarController {

    @Autowired
    private ICarService carService;

    @GetMapping()
    public List<Car> getCar() {
        List cars = (List<Car>) carService.findAll();
        return cars;
    }

}
