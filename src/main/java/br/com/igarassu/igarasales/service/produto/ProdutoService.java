package br.com.igarassu.igarasales.service.produto;

import java.util.List;

import br.com.igarassu.igarasales.dto.produto.ProdutoDTO;
import br.com.igarassu.igarasales.dto.produto.ProdutoFormDTO;

public interface ProdutoService {
    List<ProdutoDTO> listarProdutos();
    ProdutoDTO buscarProdutoPorId(Integer codigoProduto) throws Exception;

    ProdutoDTO adicionaProduto(ProdutoFormDTO produtoForm);
    ProdutoDTO editarProduto(Integer codigoProduto, ProdutoFormDTO produtoForm) throws Exception;
 
    void excluirProduto(Integer codigoProduto) throws Exception;
}
