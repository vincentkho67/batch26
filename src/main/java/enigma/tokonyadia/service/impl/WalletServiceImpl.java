package enigma.tokonyadia.service.impl;

import enigma.tokonyadia.model.WalletProvider;
import enigma.tokonyadia.repository.WalletProviderRepository;
import enigma.tokonyadia.service.WalletProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletProviderService {
    private final WalletProviderRepository walletRepo;
    @Override
    public WalletProvider create(WalletProvider request) {
        return walletRepo.save(request);
    }

    @Override
    public WalletProvider getOne(Integer id) {
        return walletRepo.findById(id).orElse(null);
    }

    @Override
    public List<WalletProvider> getAll() {
        return walletRepo.findAll();
    }
}
