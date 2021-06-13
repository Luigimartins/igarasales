package br.com.igarassu.igarasales.dto.produto;

import java.io.Serializable;

import br.com.igarassu.igarasales.domain.categoria.Categoria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoFormDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private String nome;
    private String descricao;
    private Categoria categoria;
    
}
