package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorRequest {
    
    private String nome;

    private String cpf;

    private String rg;
    
    private LocalDate dataNascimento;

    private String foneCelular;

    private String foneFixo;

    private Integer qtdEntregasRealizadas;

    private Double valorFrete;

    private String enderecoRua;

    private String enderecoComplemento;
    
    private String enderecoNumero;
    
    private String enderecoBairro;
    
    private String enderecoCidade;

    private String enderecoCep;
    
    private String enderecoUf;

    private Boolean ativo;

    public Entregador build(){
        return Entregador.builder()
        .nome(nome)
        .cpf(cpf)
        .rg(rg)
        .dataNascimento(dataNascimento)
        .foneCelular(foneCelular)
        .foneFixo(foneFixo)
        .qtdEntregasRealizadas(qtdEntregasRealizadas)
        .valorFrete(valorFrete)
        .enderecoRua(enderecoRua)
        .enderecoComplemento(enderecoComplemento)
        .enderecoNumero(enderecoNumero)
        .enderecoBairro(enderecoBairro)
        .enderecoCidade(enderecoCidade)
        .enderecoCep(enderecoCep)
        .enderecoUf(enderecoUf)
        .ativo(ativo)
        .build();
    }
}
