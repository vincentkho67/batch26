package enigma.tokonyadia.service.impl;

import enigma.tokonyadia.model.Transaction;
import enigma.tokonyadia.repository.TransactionRepository;
import enigma.tokonyadia.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository repo;

    public TransactionServiceImpl(TransactionRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Transaction> getAll() {
        return repo.findAll();
    }

    @Override
    public Transaction getOne(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Transaction create(Transaction request) {
        // Product product = productService.getById(productId);
        // Customer customer = customerService.getById(customerId);
        // TransactionDetail tDetail = transactionDetailService.create(customer, product);
        return repo.save(request);
    }
}
