package br.com.igarassu.igarasales.service.produto;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.igarassu.igarasales.convert.produto.ProdutoConvert;
import br.com.igarassu.igarasales.domain.produto.Produto;
import br.com.igarassu.igarasales.domain.categoria.Categoria;
import br.com.igarassu.igarasales.dto.produto.ProdutoDTO;
import br.com.igarassu.igarasales.dto.produto.ProdutoFormDTO;
import br.com.igarassu.igarasales.repository.produto.ProdutoRepository;
import br.com.igarassu.igarasales.repository.categoria.CategoriaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProdutoServiceImpl implements ProdutoService{

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    @Override
    public List<ProdutoDTO> listarProdutos() {
        List<Produto> produtoList = produtoRepository.findAll();
        return ProdutoConvert.produtoDomainListToDTOlist(produtoList);
    }

    @Override
    public ProdutoDTO buscarProdutoPorId(Integer codigoProduto) throws Exception {
        Optional<Produto> produtoOpt = produtoRepository.findById(codigoProduto);
    
        if (!produtoOpt.isPresent()){
            throw new Exception("Produto não encontrado");
        }

        return ProdutoConvert.produtoDomainToDTO(produtoOpt.get());
    }

    @Override
    public ProdutoDTO adicionaProduto(ProdutoFormDTO produtoForm) throws Exception {
        Optional<Categoria> categoriaOpt = categoriaRepository.findById(produtoForm.getCategoriaId());
        
        if (!categoriaOpt.isPresent()){
            throw new Exception("Categoria não encontrada");
        }

        Produto entity = ProdutoConvert.produtoFormToCategoriaEntity(produtoForm);
        entity.setCategoria(categoriaOpt.get());
        produtoRepository.save(entity);

        return ProdutoConvert.produtoDomainToDTO(entity);
    }

    @Override
    public ProdutoDTO editarProduto(Integer codigoProduto, ProdutoFormDTO produtoForm) throws Exception {
        Optional<Produto> produtoOpt = produtoRepository.findById(codigoProduto);

        if (!produtoOpt.isPresent()){
            throw new Exception("Produto não encontrado");
        }

        Optional<Categoria> categoriaOpt = categoriaRepository.findById(produtoForm.getCategoriaId());
        
        if (!categoriaOpt.isPresent()){
            throw new Exception("Categoria não encontrada");
        }

        Produto entity = produtoOpt.get();
        entity.setNome(produtoForm.getNome());
        entity.setDescricao(produtoForm.getDescricao());
        entity.setCategoria(categoriaOpt.get());
        produtoRepository.save(entity);

        return ProdutoConvert.produtoDomainToDTO(produtoOpt.get()); 
    }

    @Override
    public void excluirProduto(Integer codigoProduto) throws Exception {
        Optional<Produto> produtoOpt = produtoRepository.findById(codigoProduto);

        if(!produtoOpt.isPresent()){
            throw new Exception("Produto não encontrado");
        }

        produtoRepository.delete(produtoOpt.get());
    }
}
