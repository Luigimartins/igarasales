package br.com.igarassu.igarasales.service.categoria;

import java.util.List;

import br.com.igarassu.igarasales.dto.categoria.CategoriaDTO;
import br.com.igarassu.igarasales.dto.categoria.CategoriaFormDTO;



public interface CategoriaService {

    List<CategoriaDTO> listarCategorias();
    CategoriaDTO buscarCategoriaPorId(Integer codigoCategoria) throws Exception;

    CategoriaDTO adicionarCategoria(CategoriaFormDTO categoriaForm);
    CategoriaDTO editarCategoria(Integer codigoCategoria, CategoriaFormDTO categoriaForm) throws Exception;

    void excluirCategoria(Integer codigoCategoria) throws Exception;

    
}