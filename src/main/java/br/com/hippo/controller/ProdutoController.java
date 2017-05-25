package br.com.hippo.controller;

import br.com.hippo.entities.Produto;
import br.com.hippo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;

	@RequestMapping(
		value = "/produto/detalhe",
		method = RequestMethod.GET,
		produces = "application/json"
	)
	@ResponseBody
	public Produto readByIdParam(@RequestParam long idProduto) {
		Produto produto = repository.findOne(idProduto);
		return produto;
	}

	@RequestMapping(
		value = "/produto",
		method = RequestMethod.GET,
		produces = "application/json"
	)
	@ResponseBody
	public Iterable<Produto> readByIdCategoriaParam(@RequestParam long idCategoria) {
		Iterable<Produto> produtos = repository.findByIdCategoria(idCategoria);
		return produtos;
	}

}
