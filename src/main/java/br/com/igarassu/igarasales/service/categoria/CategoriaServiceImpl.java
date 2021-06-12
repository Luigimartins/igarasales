package br.com.igarassu.igarasales.service.categoria;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.igarassu.igarasales.convert.categoria.CategoriaConvert;
import br.com.igarassu.igarasales.domain.categoria.Categoria;
import br.com.igarassu.igarasales.dto.categoria.CategoriaDTO;
import br.com.igarassu.igarasales.dto.categoria.CategoriaFormDTO;
import br.com.igarassu.igarasales.repository.categoria.CategoriaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

	private final CategoriaRepository categoriaRepository;

	@Override
	public List<CategoriaDTO> listarCategorias() {

		List<Categoria> categoriaList = categoriaRepository.findAll();
		return CategoriaConvert.categoriaDomainListToDTOlist(categoriaList);
	}

	@Override
	public CategoriaDTO buscarCategoriaPorId(Integer codigoCategoria) throws Exception {
		Optional<Categoria> categoriaOpt = categoriaRepository.findById(codigoCategoria);
		
		if (!categoriaOpt.isPresent()) {
			throw new Exception("Categoria não encontrada");
		}
		
		return CategoriaConvert.categoriaDomainToDTO(categoriaOpt.get());
	}

	@Override
	public CategoriaDTO adicionarCategoria(CategoriaFormDTO categoriaForm) {
		
		Categoria entity = CategoriaConvert.categoriaFormToCategoriaEntity(categoriaForm);
		categoriaRepository.save(entity);
		
		return CategoriaConvert.categoriaDomainToDTO(entity);
	}

	@Override
	public CategoriaDTO editarCategoria(Integer codigoCategoria, CategoriaFormDTO categoriaForm) throws Exception {
		Optional<Categoria> categoriaOpt = categoriaRepository.findById(codigoCategoria);
		
		if (!categoriaOpt.isPresent()) {
			throw new Exception("Categoria não encontrada");
		}
		
		Categoria entity = categoriaOpt.get();
		
		entity.setNome(categoriaForm.getNome());
		categoriaRepository.save(entity);
		
		return CategoriaConvert.categoriaDomainToDTO(entity);
	}

	@Override
	public void excluirCategoria(Integer codigoCategoria) throws Exception {
		Optional<Categoria> categoriaOpt = categoriaRepository.findById(codigoCategoria);
		
		if (!categoriaOpt.isPresent()) {
			throw new Exception("Categoria não encontrada");
		}
		
		categoriaRepository.delete(categoriaOpt.get());
	}

}