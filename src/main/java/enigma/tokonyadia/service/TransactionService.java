package enigma.tokonyadia.service;

import enigma.tokonyadia.model.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getAll();
    Transaction getOne(Integer id);
    Transaction create(Transaction request);
}
