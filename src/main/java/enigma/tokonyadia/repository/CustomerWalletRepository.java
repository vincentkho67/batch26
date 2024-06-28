package enigma.tokonyadia.repository;

import enigma.tokonyadia.model.CustomerWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerWalletRepository extends JpaRepository<CustomerWallet, Integer> {
}
