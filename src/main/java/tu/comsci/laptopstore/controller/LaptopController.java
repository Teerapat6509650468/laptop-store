package tu.comsci.laptopstore.controller;

import tu.comsci.laptopstore.model.Laptop;
import tu.comsci.laptopstore.service.LaptopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptops")
@CrossOrigin(origins = "*") // (Optional) Allow cross-origin for easy testing
public class LaptopController {

    private final LaptopService laptopService;

    @Autowired
    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @GetMapping
    public List<Laptop> getAllLaptops() {
        return laptopService.getAllLaptops();
    }
}
