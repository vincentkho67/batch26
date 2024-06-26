package enigma.tokonyadia.controller;

import enigma.tokonyadia.model.Product;
import enigma.tokonyadia.repository.ProductRepository;
import enigma.tokonyadia.service.ProductService;
import enigma.tokonyadia.utils.ProductProjection;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepo;

    public ProductController(
            ProductService productService,
            ProductRepository productRepo
    ) {
        this.productRepo = productRepo;
        this.productService = productService;
    }

    @GetMapping("/product")
    public List<ProductProjection> getAllCustom() {
        return productRepo.findAllProjectedBy();
    }

    @PostMapping
    public Product create(@RequestBody Product req) {
        return productService.create(req);
    }
}
