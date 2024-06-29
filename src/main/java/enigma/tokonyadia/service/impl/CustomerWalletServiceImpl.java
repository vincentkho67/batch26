package enigma.tokonyadia.service.impl;

import enigma.tokonyadia.model.Customer;
import enigma.tokonyadia.model.CustomerWallet;
import enigma.tokonyadia.model.WalletProvider;
import enigma.tokonyadia.repository.CustomerWalletRepository;
import enigma.tokonyadia.service.CustomerService;
import enigma.tokonyadia.service.CustomerWalletService;
import enigma.tokonyadia.service.WalletProviderService;
import enigma.tokonyadia.utils.dto.TopUpRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerWalletServiceImpl implements CustomerWalletService {
    private final CustomerWalletRepository repo;
    private final CustomerService custService;
    private final WalletProviderService walletService;


    @Override
    public CustomerWallet topUp(TopUpRequestDTO request) {
        CustomerWallet newTopUp = new CustomerWallet();

        Customer cust = custService.getOne(request.getCustomer_id());
        WalletProvider wallet = walletService.getOne(request.getWallet_provider_id());

        newTopUp.setCustomer(cust);
        newTopUp.setWalletProvider(wallet);
        newTopUp.setBalance(request.getBalance());
        return repo.save(newTopUp);
    }

    @Override
    public List<CustomerWallet> getAll() {
        return repo.findAll();
    }

    @Override
    public CustomerWallet getOne(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public CustomerWallet update(CustomerWallet request) {
        CustomerWallet updated = new CustomerWallet();
        updated.setBalance(request.getBalance());
        return repo.save(updated);
    }
}
