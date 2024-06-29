package enigma.tokonyadia.service.impl;

import enigma.tokonyadia.model.*;
import enigma.tokonyadia.repository.CustomerRepository;
import enigma.tokonyadia.repository.TransactionRepository;
import enigma.tokonyadia.service.*;
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
    private final CustomerWalletService customerWalletService;
    private final WalletProviderService walletService;
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
    public Transaction buy(TransactionRequestDTO request) {
        // Flow 1 -> get product by id from request.getProduct_id
        // Product product = productService.getById(productId);
        Product product = productService.getOne(request.getProduct_id());
        // 2 -> get Customer by id from request.getCustomerId
        // Customer customer = customerService.getById(customerId);
        Customer customer = customerService.getOne(request.getCustomer_id());

        // total Price
        Integer totalPrice = product.getPrice() * request.getQuantity();

//        WalletProvider wallet = walletService.getOne(request.getWallet_provider_id());
        CustomerWallet cw = customerWalletService.getOne(request.getCustomer_wallet_id());
        Integer balance = cw.getBalance();
        // potong saldo customer

        // 3 create new transaction
        if (balance >= totalPrice) {
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

            cw.setBalance(balance - totalPrice);

            customerWalletService.update(cw.getId(),cw);

            return createdTrans;
        }
        return null;
    }
}
