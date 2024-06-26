package enigma.tokonyadia.service;

import enigma.tokonyadia.model.TransactionDetail;

import java.util.List;

public interface TransactionDetailService {
    List<TransactionDetail> getAll();
    TransactionDetail getOne(Integer id);
    TransactionDetail create(TransactionDetail request);
}
