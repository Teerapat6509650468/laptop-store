package tu.comsci.laptopstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import tu.comsci.laptopstore.model.Customer;

import java.util.List;

@Service
public class LaptopCustomerClient {

    private final RestTemplate restTemplate;
    private final String laptopCustomerBaseUrl = "http://localhost:8081";

    @Autowired
    public LaptopCustomerClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Get all customers from LaptopCustomer service
    public List<Customer> getAllCustomers() {
        ResponseEntity<List<Customer>> response = restTemplate.exchange(
                laptopCustomerBaseUrl + "/customers", 
                HttpMethod.GET, 
                null, 
                new ParameterizedTypeReference<List<Customer>>() {}
        );
        return response.getBody();
    }

    // Add a new customer to LaptopCustomer service
    public Customer addCustomer(Customer customer) {
        HttpEntity<Customer> request = new HttpEntity<>(customer);
        return restTemplate.postForObject(
                "http://localhost:8081/customers/addCustomer",
                request,
                Customer.class
        );
    }

}
