package enigma.tokonyadia.controller;

import enigma.tokonyadia.model.Customer;
import enigma.tokonyadia.repository.CustomerRepository;
import enigma.tokonyadia.service.CustomerService;
import enigma.tokonyadia.utils.CustomerProjection;
import enigma.tokonyadia.utils.SearchCustomerRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

// C 2R U D
@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerService customerService,
                              CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }
    @PostMapping
    public Customer create(@RequestBody Customer req) {
        return customerService.create(req);
    }
    // @GetMapping -> repository.findAll
    @GetMapping
    public List<Customer> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String birthPlace
            ) {
        SearchCustomerRequest req = new SearchCustomerRequest();
        req.setName(name);
        req.setBirthPlace(birthPlace);
        return customerService.getAll(req);
    }

    @GetMapping("/custom")
    public List<CustomerProjection> getAllCustom() {
        return customerRepository.findAllProjectedBy();
    }
    // @GetMapping -> repository.findById
    @GetMapping("/{id}")
    public Customer getOne(@PathVariable Integer id) {
        return customerService.getOne(id);
    }
    // @PutMapping -> this.findById repository.save
    @PutMapping("/{id}")
    public Customer update(@PathVariable Integer id, @RequestBody Customer req) {
        return customerService.update(id, req);
    }
    // @DeleteMapping -> findById, repository.delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        customerService.delete(id);
    }
}
