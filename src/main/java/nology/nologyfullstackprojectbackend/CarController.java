package nology.nologyfullstackprojectbackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    @GetMapping("/cars")
    public String getCars(){
        return "Hello Sydney";
    }
}
