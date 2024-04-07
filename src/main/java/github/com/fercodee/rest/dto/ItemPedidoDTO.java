package github.com.fercodee.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data // @Getter @Setter @ToString @EqualsAndHashCode
public class ItemPedidoDTO {
    private Integer produto;
    private Integer quantidade;
}
