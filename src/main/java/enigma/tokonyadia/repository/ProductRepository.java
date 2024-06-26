package enigma.tokonyadia.repository;

import enigma.tokonyadia.model.Product;
import enigma.tokonyadia.utils.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product>
{
    @Query("SELECT p.id AS id, p.price AS price FROM Product p")
    List<ProductProjection> findAllProjectedBy();
}
