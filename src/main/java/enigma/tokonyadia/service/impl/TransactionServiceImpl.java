package enigma.tokonyadia.service.impl;

import enigma.tokonyadia.model.Customer;
import enigma.tokonyadia.model.Product;
import enigma.tokonyadia.model.Transaction;
import enigma.tokonyadia.model.TransactionDetail;
import enigma.tokonyadia.repository.CustomerRepository;
import enigma.tokonyadia.repository.TransactionRepository;
import enigma.tokonyadia.service.CustomerService;
import enigma.tokonyadia.service.ProductService;
import enigma.tokonyadia.service.TransactionDetailService;
import enigma.tokonyadia.service.TransactionService;
import enigma.tokonyadia.utils.dto.TransactionRequestDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final CustomerService customerService;
    private final ProductService productService;
    private final TransactionDetailService tDetailService;
//    public TransactionServiceImpl(TransactionRepository repo) {
//        this.repo = repo;
//    }

    @Override
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getOne(Integer id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Transaction create(TransactionRequestDTO request) {
        // Flow 1 -> get product by id from request.getProduct_id
        // Product product = productService.getById(productId);
        Product product = productService.getOne(request.getProduct_id());
        // 2 -> get Customer by id from request.getCustomerId
        // Customer customer = customerService.getById(customerId);
        Customer customer = customerService.getOne(request.getCustomer_id());
        // 3 create new transaction
        Transaction newTransaction = new Transaction();
        newTransaction.setCustomer(customer);
        Transaction createdTrans = transactionRepository.save(newTransaction);
        // 4 create transaction_detail because we already have transaction
        // TransactionDetail tDetail = transactionDetailService.create(customer, product);
        TransactionDetail transDetail = new TransactionDetail();
        transDetail.setTransaction(createdTrans);
        transDetail.setPrice(product.getPrice());
        transDetail.setProduct(product);
        transDetail.setQuantity(request.getQuantity());
        tDetailService.create(transDetail);

        return createdTrans;
    }
}
