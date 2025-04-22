package com.vendas.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.vendas.entity.ItemVenda;
import com.vendas.service.ItemVendaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/itemVenda")
public class ItemVendaController {
	
	@Autowired
	private final ItemVendaService itemVendaService;

	public ItemVendaController(ItemVendaService itemVendaService) {
		this.itemVendaService = itemVendaService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ItemVenda> getItemVendaById(@PathVariable Long id){
		ItemVenda itemVenda = itemVendaService.getItemVendaById(id);
		if (itemVenda != null) {
			return ResponseEntity.ok(itemVenda);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/")
	public ResponseEntity<List<ItemVenda>> getAllItemVenda() {
		List<ItemVenda> itemVenda = itemVendaService.getAllItemVenda();
		return ResponseEntity.ok(itemVenda);
	}
	@PostMapping("/")
	public ResponseEntity<ItemVenda> criarItemVenda(@RequestBody @Valid ItemVenda itemVenda) {
		ItemVenda criarItemVenda = itemVendaService.salvarItemVenda(itemVenda);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarItemVenda);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ItemVenda> updateItemVenda(@PathVariable Long id, @RequestBody @Valid ItemVenda itemVenda) {
		ItemVenda updatedItemVenda = itemVendaService.updateItemVenda(id, itemVenda);
		if (updatedItemVenda != null) {
			return ResponseEntity.ok(updatedItemVenda);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ItemVenda> deleteItemVenda(@PathVariable Long id) {
		boolean deleted = itemVendaService.deleteItemVenda(id);
		if (deleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}


