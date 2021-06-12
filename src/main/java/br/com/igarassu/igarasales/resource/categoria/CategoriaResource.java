package br.com.igarassu.igarasales.resource.categoria;

import java.util.List;

import org.springframework.http.HttpStatus;
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

import br.com.igarassu.igarasales.dto.categoria.CategoriaDTO;
import br.com.igarassu.igarasales.dto.categoria.CategoriaFormDTO;
import br.com.igarassu.igarasales.service.categoria.CategoriaService;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("v1/igarasales/categoria")
@RequiredArgsConstructor
public class CategoriaResource {

	private final CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> listarCategorias() {
		return ResponseEntity.ok(categoriaService.listarCategorias());
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<CategoriaDTO> buscarCategoria(@PathVariable("codigo") Integer codigoCategoria)
			throws Exception {
		return ResponseEntity.ok(categoriaService.buscarCategoriaPorId(codigoCategoria));
	}

	@PostMapping
	public ResponseEntity<CategoriaDTO> salvarCategoria(@RequestBody CategoriaFormDTO categoriaFormDTO)
			throws Exception {

		CategoriaDTO categoria = categoriaService.adicionarCategoria(categoriaFormDTO);

		return ResponseEntity.ok(categoria);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<CategoriaDTO> editarCategoria(@PathVariable("codigo") Integer codigoCategoria,
			@RequestBody CategoriaFormDTO categoriaFormDTO) throws Exception {

		CategoriaDTO categoria = categoriaService.editarCategoria(codigoCategoria, categoriaFormDTO);

		return ResponseEntity.status(HttpStatus.OK).body(categoria);
	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<CategoriaDTO> excluirCategoria(@PathVariable("codigo") Integer codigoCategoria)
			throws Exception {

		categoriaService.excluirCategoria(codigoCategoria);

		return ResponseEntity.ok().build();
	}

}
