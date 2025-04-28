package tu.comsci.laptopstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tu.comsci.laptopstore.service.LaptopCustomerClient;
import tu.comsci.laptopstore.model.Customer;
import java.util.List;

@RestController
@RequestMapping("/store")
@CrossOrigin(origins = "*") 
public class LaptopStoreController {

    private final LaptopCustomerClient laptopCustomerClient;

    @Autowired
    public LaptopStoreController(LaptopCustomerClient laptopCustomerClient) {
        this.laptopCustomerClient = laptopCustomerClient;
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomersFromLaptopCustomer() {
        return laptopCustomerClient.getAllCustomers();
    }

    @PostMapping("/customers/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = laptopCustomerClient.addCustomer(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }
}
