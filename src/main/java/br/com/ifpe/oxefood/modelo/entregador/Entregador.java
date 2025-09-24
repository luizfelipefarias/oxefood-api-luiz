package br.com.ifpe.oxefood.modelo.entregador;

import java.time.LocalDate;

import org.hibernate.annotations.SQLRestriction;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Marca esta classe como uma entidade JPA (vai virar uma tabela no banco de dados)
@Entity
// Define o nome da tabela no banco de dados

@Table(name = "Entregador")//não é obrigatória. Serve para definir nome da tabela,colunas unicas,indices, schemas e etc

// (Hibernate) Só traz registros onde habilitado = true. Funciona como se fosse um WHERE em uma consulta na tabela
@SQLRestriction("habilitado = true")

// Lombok: cria automaticamente um "builder" (Entregador.builder().campo(...).build()). Vai servir para usar no request, criando instancias da entidade sem se preocupar muito com o preenchimento dos parametros na construção do objeto.
@Builder 

// Lombok: cria automaticamente os métodos getter
@Getter

// Lombok: cria automaticamente os métodos setter
@Setter 

// Lombok: cria um construtor com todos os atributos
@AllArgsConstructor

// Lombok: cria um construtor sem parâmetros
@NoArgsConstructor
public class Entregador extends EntidadeAuditavel {
    @Column
    private String nome;
    @Column
    private String cpf;
    @Column
    private String rg;
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
