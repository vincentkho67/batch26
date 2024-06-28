package enigma.tokonyadia.utils.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TopUpRequestDTO {
    Integer customer_id;
    Integer wallet_provider_id;
    Integer balance;
}
