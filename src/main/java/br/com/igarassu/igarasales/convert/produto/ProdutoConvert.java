package br.com.igarassu.igarasales.convert.produto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.igarassu.igarasales.domain.produto.Produto;
import br.com.igarassu.igarasales.dto.produto.ProdutoDTO;
import br.com.igarassu.igarasales.dto.produto.ProdutoFormDTO;


public class ProdutoConvert {
    private ProdutoConvert(){

    }

    public static List<ProdutoDTO> produtoDomainListToDTOlist(List<Produto> domainList){
        return domainList.stream().map(ProdutoConvert::produtoDomainToDTO).collect(Collectors.toList());
    }

    public static ProdutoDTO produtoDomainToDTO(Produto domain) {
        return ProdutoDTO.builder().codigo(domain.getCodigo())
                                   .nome(domain.getNome())
                                   .descricao(domain.getDescricao())
                                //    .categoria(domain.getCategoria())
                                   .build();
    }

    public static Produto produtoFormToCategoriaEntity(ProdutoFormDTO produtoForm){
        return Produto.builder().nome(produtoForm.getNome())
                                .descricao(produtoForm.getDescricao())
                                // .categoria(produtoForm.getCategoria())
                                .build();
    }
}
