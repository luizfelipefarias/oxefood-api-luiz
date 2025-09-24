package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Lombok: cria getters, setters, toString, equals e hashCode
@Data

// Lombok: gera um builder para esta classe,só vai funcionar se em Entregador.java tbm tiver o @Builder
@Builder

@NoArgsConstructor

@AllArgsConstructor

public class EntregadorRequest {

    private String nome;

    private String cpf;

    private String rg;

    // Define o formato de data esperado no JSON: "dd/MM/yyyy"
    @JsonFormat(pattern = "dd/MM/yyyy")
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
    
    // Método que converte este DTO em uma entidade Entregador
    public Entregador build(){
        return Entregador.builder() // --> Inicializa o builder da entidade Entregador, ou seja,inicializa o construtor fluente. 
        //O construtor fluente você encadeie chamadas de métodos, ou seja, não precisa ficar repetindo o nome do objeto a cada operação.
        //Cada método retorna o próprio objeto builder, então você não precisa escrever o nome do objeto várias vezes.
            .nome(nome) // passa o campo nome e retorna o builder para permitir o encadeamento
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
            .build();// --> n esquece de colocar pois ele cria o objeto Entregador, ele  finaliza a construção e retorna a instância final de Entregador preenchida com todos os valores que você passou. Diferente dos outros parametros o .build() retorna o objeto final e não o builder
    }
}
