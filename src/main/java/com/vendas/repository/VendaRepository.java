package com.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendas.entity.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{

}
