package br.com.ifpe.oxefood.modelo.entregador;

import java.time.LocalDate;

import org.hibernate.annotations.SQLRestriction;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Entregador")
@SQLRestriction("habilitado = true")

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Entregador extends EntidadeAuditavel {
    
    @Column
    private String nome;

    @Column
    private String cpf;

    @Column
    private String rg;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column
    private LocalDate dataNascimento;

    @Column
    private String foneCelular;

    @Column
    private String foneFixo;

    @Column
    private Integer qtdEntregasRealizadas;

    @Column
    private Double valorFrete;

    @Column
    private String enderecoRua;

    @Column
    private String enderecoComplemento;
    
    @Column
    private String enderecoNumero;
    
    @Column
    private String enderecoBairro;
    
    @Column
    private String enderecoCidade;

    
    @Column
    private String enderecoCep;
    
    @Column
    private String enderecoUf;

    @Column
    private Boolean ativo;
}
