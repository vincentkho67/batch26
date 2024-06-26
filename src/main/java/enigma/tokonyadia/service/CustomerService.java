package enigma.tokonyadia.service;

import enigma.tokonyadia.model.Customer;
import enigma.tokonyadia.utils.SearchCustomerRequest;

import java.util.List;

// interface => kontrak
//
public interface CustomerService {
    List<Customer> getAll(SearchCustomerRequest req);
    Customer getOne(Integer id);
    Customer create(Customer req);
    Customer update(Integer id, Customer req);
    void delete(Integer id);
}
