package enigma.tokonyadia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customer_wallet")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerWallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "wallet_provider_id")
    private WalletProvider walletProvider;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private Integer balance;
}
