package nology.nologyfullstackprojectbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {
    @Autowired
    CarRepository carRepository;
/*
    @GetMapping("/car")
    public String getCar(){
        return "Hello Everyone, still working";
    }
*/
    @GetMapping("/car")
    public List<Car> getCar(){
        return carRepository.findAll();
    }
}
