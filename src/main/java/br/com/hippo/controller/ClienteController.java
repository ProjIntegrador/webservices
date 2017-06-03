package br.com.hippo.controller;

import br.com.hippo.entities.AutenticacaoCliente;
import br.com.hippo.entities.Cliente;
import br.com.hippo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClienteController {

	@Autowired
	private ClienteRepository repository;

	@RequestMapping(
		value = "/cliente",
		method = RequestMethod.POST,
		consumes = "application/json",
		produces = "application/json"
	)
	@ResponseBody
	public Cliente create(@RequestBody Cliente novoCliente) {
		Cliente cliente = repository.save(novoCliente);
		AutenticacaoCliente autenticacaoCliente = new AutenticacaoCliente(cliente);
		Authentication auth = new UsernamePasswordAuthenticationToken(autenticacaoCliente.getUsername(), autenticacaoCliente.getPassword());
		SecurityContextHolder.getContext().setAuthentication(auth);
		return cliente;
	}

	@RequestMapping(
		value = "/cliente/{id}",
		method = RequestMethod.GET,
		produces = "application/json"
	)
	@ResponseBody
	public Cliente readById(@PathVariable long id) {
		Cliente cliente = repository.findOne(id);
		return cliente;
	}

	@RequestMapping(
		value = "/cliente/",
		method = RequestMethod.GET,
		produces = "application/json"
	)
	@ResponseBody
	public Cliente readById() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		AutenticacaoCliente autenticacaoCliente = (AutenticacaoCliente) authentication.getPrincipal();
		Cliente cliente = autenticacaoCliente.getCliente();
		return cliente;
	}

}
