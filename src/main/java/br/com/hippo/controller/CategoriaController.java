package br.com.hippo.controller;

import br.com.hippo.entities.Categoria;
import br.com.hippo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;

	@RequestMapping(
		method = RequestMethod.GET,
		value = "/categoria",
		produces = "application/json"
	)
	@ResponseBody
	public Iterable<Categoria> read() {
		Iterable<Categoria> categorias = repository.findAll();
		return categorias;
	}

}
