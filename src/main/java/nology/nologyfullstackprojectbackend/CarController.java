package nology.nologyfullstackprojectbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = {"http://localhost:3000"})
@CrossOrigin(origins = {"*"})

public class CarController {
    @Autowired
    CarRepository carRepository;

    @GetMapping("/car/{carId}")
    public Optional<Car> getCar(@PathVariable int carId){
        return this.carRepository.findById(carId);
    }

    @PostMapping("/car")
    public Car addCar(@RequestBody Car text){
        Car newCar = this.carRepository.save(text);
        System.out.println("Added " + text);
        return newCar;
    }

    @GetMapping("/cars")
    public List<Car> getCars(){
        return carRepository.findAll();
    }

    @DeleteMapping("/car/{carId}")
    @Transactional
    public String deletePokemon(@PathVariable int carId) {
        System.out.println("pokemon = " + carId);
        int deleted = this.carRepository.deleteCarByCarId(carId);
        if (deleted > 0) return "Car was deleted okay";
        return "Car Id: " + carId +" does not exist";
    }

    @PutMapping("/car/{carId}")
    public String updateCar(@PathVariable int carId, @RequestBody Car carInfo){
        Optional<Car> existingCar = carRepository.findById(carId);
        if (existingCar.isEmpty()) return "Car: " + carId + " Does not exist.";
        Car savedCar = this.carRepository.save(carInfo);
        return "Car " + carInfo.getModel() + " saved okay";
    }
}
