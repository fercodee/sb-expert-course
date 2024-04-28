package github.com.fercodee.rest.dto;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data // @Getter @Setter @ToString @EqualsAndHashCode
public class PedidoDTO {
    @NotNull(message = "Informe o código do cliente.")
    private Integer cliente;
    
    @NotNull(message = "Campo total é obrigatório.")
    private BigDecimal total;

    @NotEmpty(message = "O pedido deve ter pelo menos um item.") // Hibernate Validator
    private List<ItemPedidoDTO> items;
}
