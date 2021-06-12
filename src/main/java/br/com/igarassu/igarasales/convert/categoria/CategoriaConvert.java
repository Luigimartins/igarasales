package br.com.igarassu.igarasales.convert.categoria;

import java.util.List;
import java.util.stream.Collectors;

import br.com.igarassu.igarasales.domain.categoria.Categoria;
import br.com.igarassu.igarasales.dto.categoria.CategoriaDTO;
import br.com.igarassu.igarasales.dto.categoria.CategoriaFormDTO;

public class CategoriaConvert {
	
	private CategoriaConvert() {
	}
	
	public static List<CategoriaDTO> categoriaDomainListToDTOlist(List<Categoria> domainList) {
			return domainList.stream().map(CategoriaConvert::categoriaDomainToDTO).collect(Collectors.toList());
	}

	public static CategoriaDTO categoriaDomainToDTO(Categoria domain) {
		return CategoriaDTO.builder().codigo(domain.getCodigo()).nome(domain.getNome()).build();
	}
	
	public static Categoria categoriaFormToCategoriaEntity(CategoriaFormDTO categoriaForm) {
		return Categoria.builder().nome(categoriaForm.getNome()).build();
	}

}
