package br.com.hippo.controller;

import br.com.hippo.entities.Produto;
import br.com.hippo.repository.ProdutoRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

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
			value = "/produto/img",
			method = RequestMethod.GET
	)
	@ResponseBody
	public String readImage(@RequestParam long idProduto) throws IOException {
		byte[] imagemBytes = repository.findImageByProdutoId(idProduto);

		StringBuilder sb = new StringBuilder();
//		sb.append("data:image/png;base64,");
		sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(imagemBytes, false)));
		return sb.toString();
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
