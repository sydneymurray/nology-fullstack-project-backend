package nology.nologyfullstackprojectbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {
    @Autowired
    CarRepository carRepository;

    @GetMapping("/car")
    public String getCar(){
        return "Hello Everyone, still working";
    }

    @PostMapping("/car")
    public String addCar (@RequestBody Car text) {
        this.carRepository.save(text);
        System.out.println("Added " + text);
        return "Car saved okay";
    }

    @GetMapping("/cars")
    public List<Car> getCars(){
        return carRepository.findAll();
    }


}
