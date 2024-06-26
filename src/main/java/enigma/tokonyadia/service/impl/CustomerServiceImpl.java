package enigma.tokonyadia.service.impl;

import enigma.tokonyadia.model.Customer;
import enigma.tokonyadia.repository.CustomerRepository;
import enigma.tokonyadia.service.CustomerService;
import enigma.tokonyadia.utils.CustomerProjection;
import enigma.tokonyadia.utils.SearchCustomerRequest;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepo;

    public CustomerServiceImpl(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public List<Customer> getAll(SearchCustomerRequest req) {
        Specification<Customer> specification = getCustomerSpecification(req);
        return customerRepo.findAll(specification);
    }

    @Override
    public Customer getOne(Integer id) {
        return customerRepo.findById(id).orElse(null);
    }

    @Override
    public Customer create(Customer req) {
        return customerRepo.save(req);
    }

    @Override
    public Customer update(Integer id, Customer req) {
        Customer customer = this.getOne(id);
        customer.setName(req.getName());
        customerRepo.save(customer);
        return customer;
    }

    @Override
    public void delete(Integer id) {
        customerRepo.deleteById(id);
    }

    private Specification<Customer> getCustomerSpecification(SearchCustomerRequest req) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>(); // -> array of predicates
            // ?name="randy"&birthPlace="solo"&~~~~
            if (req.getName() != null) {
                 Predicate namePredicate = criteriaBuilder.like(
                  root.get("name"),
                  "%" + req.getName() + "%"
                );
                 predicates.add(namePredicate);
            }

            if (req.getBirthPlace() != null) {
                Predicate birthPlacePredicate = criteriaBuilder.like(
                        root.get("birthPlace"),
                        "%" + req.getBirthPlace() + "%"
                );
                predicates.add(birthPlacePredicate);
            }
            return query.where(predicates.toArray(new Predicate[] {}))
                    .getRestriction();
        };
    }
}
