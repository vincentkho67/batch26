package enigma.tokonyadia.service;

import enigma.tokonyadia.model.CustomerWallet;
import enigma.tokonyadia.utils.dto.TopUpRequestDTO;

import java.util.List;

public interface CustomerWalletService {
    CustomerWallet topUp(TopUpRequestDTO request);
    List<CustomerWallet> getAll();
    CustomerWallet getOne(Integer id);
}
