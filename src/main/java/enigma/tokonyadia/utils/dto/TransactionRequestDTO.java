package enigma.tokonyadia.utils.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionRequestDTO {
    Integer customer_id;
    Integer product_id;
    Integer quantity;
    Integer customer_wallet_id;
}
