package enigma.tokonyadia.service;

import enigma.tokonyadia.model.WalletProvider;

import java.util.List;

public interface WalletProviderService {
    // CRUD
    WalletProvider create(WalletProvider request);
    WalletProvider getOne(Integer id);
    List<WalletProvider> getAll();
}
