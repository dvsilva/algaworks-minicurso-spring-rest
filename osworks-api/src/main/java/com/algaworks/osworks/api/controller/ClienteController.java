package com.algaworks.osworks.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.domain.model.Cliente;

@RestController
public class ClienteController {

	@GetMapping("/clientes")
	private List<Cliente> listar() {
		var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("João das Coves");
		cliente1.setTelefone("34 99999-1111");
		cliente1.setEmail("joaodascoves@algaworks.com");
		
		var cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Maria");
		cliente2.setTelefone("11 77777-1111");
		cliente2.setEmail("mariadasilva@algaworks.com");
		
		return Arrays.asList(cliente1, cliente2);
	}
}
