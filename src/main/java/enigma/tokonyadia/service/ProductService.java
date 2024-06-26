package enigma.tokonyadia.service;

import enigma.tokonyadia.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getOne(Integer id);
    Product create(Product req);
    Product update(Integer id, Product req);
    void delete(Integer id);
}
