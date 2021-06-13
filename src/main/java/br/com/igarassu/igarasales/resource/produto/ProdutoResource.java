package br.com.igarassu.igarasales.resource.produto;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.igarassu.igarasales.dto.produto.ProdutoDTO;
import br.com.igarassu.igarasales.dto.produto.ProdutoFormDTO;
import br.com.igarassu.igarasales.service.produto.ProdutoService;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("v1/igarasales/produto")
@RequiredArgsConstructor
public class ProdutoResource {
    private final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarProdutos(){
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ProdutoDTO> buscarProduto(@PathVariable("codigo") Integer codigoProduto)
            throws Exception{
        return ResponseEntity.ok(produtoService.buscarProdutoPorId(codigoProduto));
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> salvarProduto(@RequestBody ProdutoFormDTO produtoFormDTO) throws Exception{
        ProdutoDTO produto = produtoService.adicionaProduto(produtoFormDTO);

        return ResponseEntity.ok(produto);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<ProdutoDTO> editarProduto(@PathVariable("codigo") Integer codigoFormDTO,
        @RequestBody ProdutoFormDTO produtoFormDTO) throws Exception{
        
        ProdutoDTO produto = produtoService.editarProduto(codigoFormDTO, produtoFormDTO);

        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<ProdutoDTO> excluirProduto(@PathVariable("codigo") Integer codigoProduto) throws Exception{
        produtoService.excluirProduto(codigoProduto);
        return ResponseEntity.ok().build();
    }
}
