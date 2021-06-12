package br.com.igarassu.igarasales.repository.produto;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.igarassu.igarasales.domain.produto.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}