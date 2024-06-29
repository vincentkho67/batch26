package enigma.tokonyadia.service;

import enigma.tokonyadia.model.Transaction;
import enigma.tokonyadia.utils.dto.TransactionRequestDTO;

import java.util.List;

public interface TransactionService {
    List<Transaction> getAll();
    Transaction getOne(Integer id);
    Transaction buy(TransactionRequestDTO request);
}
