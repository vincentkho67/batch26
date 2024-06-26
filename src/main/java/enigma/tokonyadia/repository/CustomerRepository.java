package enigma.tokonyadia.repository;

import enigma.tokonyadia.model.Customer;
import enigma.tokonyadia.utils.CustomerProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>
        , JpaSpecificationExecutor<Customer> {
    // Query Method
    // SELECT * FROM customers WHERE saldo < 10.000 AND saldo > 5.000  5000-10000
    Customer findByName(String name);
//    {
        // function body -> method body
//    };
    Customer findByBirthPlace(String birthPlace);

    @Query("SELECT c.id AS id, c.name AS name FROM Customer c")
    List<CustomerProjection> findAllProjectedBy();
    // TODO:
    // apply specification di product
    // apply projection di product -> id,price
}
