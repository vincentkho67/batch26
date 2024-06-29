package enigma.tokonyadia.model;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "wallet_providers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class WalletProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

//    @OneToMany
//    @JoinColumn(name = "customer_id")
    @OneToMany
    @JoinColumn(name = "wallet_provider_id")
    List<CustomerWallet> customerWallets;
}
