package github.com.fercodee.rest.dto;

import java.math.BigDecimal;
import java.util.List;

// import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import github.com.fercodee.validation.NotEmptyList;
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

    // @NotEmpty(message = "O pedido deve ter pelo menos um item.") // Hibernate Validator
    @NotEmptyList(message = "Pedido não pode ser realizado sem itens.")
    private List<ItemPedidoDTO> items;
}
