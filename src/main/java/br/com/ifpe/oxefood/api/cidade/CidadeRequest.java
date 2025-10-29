package br.com.ifpe.oxefood.api.cidade;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.cidade.Cidade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CidadeRequest {
    
    private Long idEstado;

    private String nome;

    private Boolean ehCapital;

    private Integer qtdPopulacao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFundacao;

    public Cidade build() {
        return Cidade.builder()
            
            .nome(nome)
            .ehCapital(ehCapital)
            .qtdPopulacao(qtdPopulacao)
            .dataFundacao(dataFundacao)
            .build();
    }
}
