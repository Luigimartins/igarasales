package br.com.igarassu.igarasales.repository.categoria;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.igarassu.igarasales.domain.categoria.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
        
}