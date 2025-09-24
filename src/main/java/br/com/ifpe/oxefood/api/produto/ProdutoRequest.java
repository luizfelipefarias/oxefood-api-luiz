package br.com.ifpe.oxefood.api.produto;


import br.com.ifpe.oxefood.modelo.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequest {
    
    private String codigo;
    
    private String titulo;
    
    private String descricao;
    
    private Double valorUnitario;
    
    private Integer tempoEntregaMaximo;
    
    private Integer tempoEntregaMinimo;

    public Produto build(){
        return Produto.builder()
                    .codigo(codigo)
                    .titulo(titulo)
                    .descricao(descricao)
                    .valorUnitario(valorUnitario)
                    .tempoEntregaMaximo(tempoEntregaMaximo)
                    .build();
    }
}
