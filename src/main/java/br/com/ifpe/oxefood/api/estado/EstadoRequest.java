package br.com.ifpe.oxefood.api.estado;

import br.com.ifpe.oxefood.modelo.estado.Estado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstadoRequest {
    
    private String nome;

    private String sigla;

    public Estado build() {

    return Estado.builder()
        .nome(nome)
        .sigla(sigla)
        .build();
  }
}
