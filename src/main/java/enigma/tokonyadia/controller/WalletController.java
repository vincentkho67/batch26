package enigma.tokonyadia.controller;

import enigma.tokonyadia.model.CustomerWallet;
import enigma.tokonyadia.model.WalletProvider;
import enigma.tokonyadia.service.CustomerWalletService;
import enigma.tokonyadia.service.WalletProviderService;
import enigma.tokonyadia.utils.dto.TopUpRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallet")
@RequiredArgsConstructor
public class WalletController {
    private final WalletProviderService walletService;
    private final CustomerWalletService customerWalletService;

    @PostMapping
    public WalletProvider create(@RequestBody WalletProvider request) {
        return walletService.create(request);
    }

    @GetMapping
    public List<WalletProvider> getAll() {
        return walletService.getAll();
    }

    @GetMapping("/{id}")
    public WalletProvider getOne(@PathVariable Integer id) {
        return walletService.getOne(id);
    }

    @PostMapping("/top_up")
    public CustomerWallet topUp(@RequestBody TopUpRequestDTO request) {
        return customerWalletService.topUp(request);
    }
}
