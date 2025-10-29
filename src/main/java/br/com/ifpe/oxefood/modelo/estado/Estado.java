package br.com.ifpe.oxefood.modelo.estado;

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

@Entity
@Table(name = "Estado")
@SQLRestriction("habilitado = true")

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estado extends EntidadeAuditavel {
    
    @Column
    private String nome;

    @Column
    private String sigla;

}
