package com.algaworks.osworks.api.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.domain.model.Cliente;
import com.algaworks.osworks.domain.repository.ClienteRepository;
import com.algaworks.osworks.domain.service.CadastroClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CadastroClienteService cadastroCliente;

	@GetMapping
	private List<Cliente> listar() {
		// return manager.createQuery("from Cliente", Cliente.class).getResultList();
		// return clienteRepository.findByNome("João da Silva");
		// return clienteRepository.findByNomeContaining("Silva");
		return clienteRepository.findAll();
	}

	@GetMapping("/{clienteId}")
	private ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);

		if (cliente.isPresent())
			return ResponseEntity.ok(cliente.get());
		else
			return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private Cliente adicionar(@Valid @RequestBody Cliente cliente) {
		return cadastroCliente.salvar(cliente);
	}

	@PutMapping("/{clienteId}")
	private ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long clienteId, @RequestBody Cliente cliente) {

		if (!clienteRepository.existsById(clienteId))
			return ResponseEntity.notFound().build();

		cliente.setId(clienteId);
		cliente = cadastroCliente.salvar(cliente);

		return ResponseEntity.ok(cliente);
	}

	@DeleteMapping("/{clienteId}")
	@ResponseStatus(HttpStatus.CREATED)
	private ResponseEntity<Void> atualizar(@PathVariable Long clienteId) {
		if (!clienteRepository.existsById(clienteId))
			return ResponseEntity.notFound().build();

		cadastroCliente.excluir(clienteId);

		return ResponseEntity.noContent().build();
	}

	public List<Cliente> gerarClientes() {
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
