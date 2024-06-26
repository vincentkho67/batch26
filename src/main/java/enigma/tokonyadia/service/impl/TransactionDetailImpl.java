package enigma.tokonyadia.service.impl;

import enigma.tokonyadia.model.TransactionDetail;
import enigma.tokonyadia.repository.TransactionDetailRepository;
import enigma.tokonyadia.service.TransactionDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionDetailImpl implements TransactionDetailService {
    private final TransactionDetailRepository repo;

    public TransactionDetailImpl(TransactionDetailRepository repo) {
        this.repo = repo;
    }
    @Override
    public List<TransactionDetail> getAll() {
        return repo.findAll();
    }

    @Override
    public TransactionDetail getOne(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public TransactionDetail create(TransactionDetail request) {
        return repo.save(request);
    }
}
