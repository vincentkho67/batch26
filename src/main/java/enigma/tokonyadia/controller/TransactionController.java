package enigma.tokonyadia.controller;

import enigma.tokonyadia.model.Transaction;
import enigma.tokonyadia.service.TransactionDetailService;
import enigma.tokonyadia.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
    private final TransactionDetailService transactionDetailService;

    @PostMapping
    public Transaction create(@RequestBody Transaction request) {
        return transactionService.create(request);
    }

    @GetMapping
    public List<Transaction> getAll() {
        return transactionService.getAll();
    }
}
