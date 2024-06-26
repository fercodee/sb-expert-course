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
    @NotNull(message = "{campo.codigo-cliente.obrigatorio}")
    private Integer cliente;
    
    @NotNull(message = "campo.total-pedido.obrigatorio")
    private BigDecimal total;

    // @NotEmpty(message = "O pedido deve ter pelo menos um item.") // Hibernate Validator
    @NotEmptyList(message = "campo.items-pedido.obrigatorio")
    private List<ItemPedidoDTO> items;
}
