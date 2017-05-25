package br.com.hippo.repository;

import br.com.hippo.entities.ItemPedido;
import br.com.hippo.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query(value =
            "INSERT INTO ItemPedido " +
                    "(idProduto, idPedido, qtdProduto, precoVendaItem) " +
                    "VALUES " +
                    "(:p.idProduto, :p.idPedido, :p.qtdProduto, :p.precoVendaItem);",
            nativeQuery = true
    )
    ItemPedido saveItens(@Param("p") ItemPedido itemPedido);
}
