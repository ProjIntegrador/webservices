package br.com.hippo.repository;

import br.com.hippo.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT p FROM Produto p JOIN FETCH p.categoria c WHERE c.idCategoria = :idCategoria")
    Iterable<Produto> findByIdCategoria(@Param("idCategoria") long idCategoria);

    @Query(
        value = "select imagem from produto where idProduto = :idProduto",
        nativeQuery = true
    )
    byte[] findImageByProdutoId(@Param("idProduto") long idProduto);
}
