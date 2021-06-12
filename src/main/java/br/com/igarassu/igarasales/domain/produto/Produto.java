package br.com.igarassu.igarasales.domain.produto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.com.igarassu.igarasales.domain.categoria.Categoria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private Integer codigo;
    private String nome;
    private String descricao;
    private Categoria categoria;
    
}