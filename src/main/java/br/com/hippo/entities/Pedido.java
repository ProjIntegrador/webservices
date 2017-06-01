package br.com.hippo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Pedido implements Serializable{

	@Id
	@GeneratedValue
	private Long idPedido;
	private Long idCliente;
	private Long idStatus;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dataPedido;
	private Long idTipoPagto;
	private Long idEndereco;
	private Long idAplicacao;
	@Transient
	private List<Item> itens;

	public Pedido() {
	}

	@PrePersist
	protected void onCreate() {
		dataPedido = new Date();
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(Long idStatus) {
		this.idStatus = idStatus;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Long getIdTipoPagto() {
		return idTipoPagto;
	}

	public void setIdTipoPagto(Long idTipoPagto) {
		this.idTipoPagto = idTipoPagto;
	}

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public Long getIdAplicacao() {
		return idAplicacao;
	}

	public void setIdAplicacao(Long idAplicacao) {
		this.idAplicacao = idAplicacao;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
}