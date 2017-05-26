package br.com.hippo.entities;

import java.io.Serializable;
import java.util.List;

public class ItemPedido implements Serializable {

	private Long idPedido;
	private List<Item> itens;

	public ItemPedido() {
	}

	public ItemPedido(Long idPedido, List<Item> itens) {
		this.idPedido = idPedido;
		this.itens = itens;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
}