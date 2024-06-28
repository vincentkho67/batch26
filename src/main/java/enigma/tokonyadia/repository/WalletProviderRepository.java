package enigma.tokonyadia.repository;

import enigma.tokonyadia.model.WalletProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletProviderRepository extends JpaRepository<WalletProvider, Integer> {
}
