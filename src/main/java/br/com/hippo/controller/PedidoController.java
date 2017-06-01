package br.com.hippo.controller;

import br.com.hippo.entities.Item;
import br.com.hippo.entities.ItemPedido;
import br.com.hippo.entities.Pedido;
import br.com.hippo.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PedidoController {

	@Autowired
	private PedidoRepository repository;

	@RequestMapping(
		value = "/pedido",
		method = RequestMethod.POST,
		consumes = "application/json",
		produces = "application/json"
	)
	@ResponseBody
	public Pedido create(@RequestBody Pedido novoPedido) {
		Pedido pedido = repository.save(novoPedido);
		for(Item item : novoPedido.getItens()){
			repository.saveIten(
				pedido.getIdPedido(),
				item.getIdProduto(),
				item.getQtdProduto(),
				item.getPrecoVendaItem()
			);
		}
		return pedido;
	}

	@RequestMapping(
		value = "/pedido/{id}",
		method = RequestMethod.GET,
		produces = "application/json"
	)
	@ResponseBody
	public Pedido readPedido(@PathVariable long id) {
		Pedido pedido = repository.findOne(id);
		return pedido;
	}

}
