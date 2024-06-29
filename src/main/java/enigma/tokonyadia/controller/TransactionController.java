package enigma.tokonyadia.controller;

import enigma.tokonyadia.model.Transaction;
import enigma.tokonyadia.service.TransactionDetailService;
import enigma.tokonyadia.service.TransactionService;
import enigma.tokonyadia.utils.dto.TransactionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    public Transaction create(@RequestBody TransactionRequestDTO request) {
        return transactionService.buy(request);
    }

    @GetMapping
    public List<Transaction> getAll() {
        return transactionService.getAll();
    }
}
