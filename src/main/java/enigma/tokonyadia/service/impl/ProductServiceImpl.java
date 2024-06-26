package enigma.tokonyadia.service.impl;

import enigma.tokonyadia.model.Product;
import enigma.tokonyadia.repository.ProductRepository;
import enigma.tokonyadia.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepo;
    public ProductServiceImpl(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }
    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Product getOne(Integer id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public Product create(Product req) {
        return productRepo.save(req);
    }

    @Override
    public Product update(Integer id, Product req) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
