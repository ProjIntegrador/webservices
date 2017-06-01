package br.com.hippo.repository;

import br.com.hippo.entities.Item;
import br.com.hippo.entities.ItemPedido;
import br.com.hippo.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.math.BigDecimal;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query(value =
            "INSERT INTO ItemPedido " +
                    "(idProduto, idPedido, qtdProduto, precoVendaItem) " +
                    "VALUES " +
                    "(:p.idProduto, :p.idPedido, :p.qtdProduto, :p.precoVendaItem);",
            nativeQuery = true
    )
    ItemPedido saveItemPedido(@Param("p") ItemPedido itemPedido);

    @Query(value =
            "INSERT INTO ItemPedido " +
                    "(idPedido, idProduto, qtdProduto, precoVendaItem) " +
                    "VALUES " +
                    "(?1, ?2, ?3, ?4);",
            nativeQuery = true
    )
    @Modifying
    @Transactional
    int saveIten(
            @Param("idPedido") Long idPedido,
            @Param("idProduto") Long idProduto,
            @Param("qtdProduto") Integer qtdProduto,
            @Param("precoVendaItem") BigDecimal precoVendaItem);

//    @Query(value =
//            "INSERT INTO ItemPedido " +
//                    "(idProduto, idPedido, qtdProduto, precoVendaItem) " +
//                    "VALUES " +
//                    "(:#{[0].idProduto}, :idPedido, :#{[0].qtdProduto}, :#{[0].precoVendaItem});",
//            nativeQuery = true
//    )
//    ItemPedido saveIten2(
//            @Param("item") Item item,
//            @Param("idPedido") Long idPedido);
}
