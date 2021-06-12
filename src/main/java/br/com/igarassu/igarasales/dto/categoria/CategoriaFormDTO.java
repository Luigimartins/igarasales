package br.com.igarassu.igarasales.dto.categoria;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoriaFormDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	
}
