package tu.comsci.laptopstore.service;

import tu.comsci.laptopstore.model.Laptop;
import tu.comsci.laptopstore.repository.LaptopRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {

    private final LaptopRepository laptopRepository;

    @Autowired
    public LaptopService(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }
}