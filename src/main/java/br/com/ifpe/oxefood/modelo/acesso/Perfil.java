package br.com.ifpe.oxefood.modelo.acesso;

import org.hibernate.annotations.SQLRestriction;
import org.springframework.security.core.GrantedAuthority;

import br.com.ifpe.oxefood.util.entity.EntidadeNegocio;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Perfil")
@SQLRestriction("habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Perfil extends EntidadeNegocio implements GrantedAuthority {

    public static final String ROLE_CLIENTE = "CLIENTE";
    public static final String ROLE_FUNCIONARIO_ADMIN = "ROLE_FUNCIONARIO_ADMIN"; // READ, DELETE, WRITE, UPDATE.
    public static final String ROLE_FUNCIONARIO_USER = "ROLE_FUNCIONARIO_USER"; // READ, WRITE, UPDATE.

    @Column
    private String nome;

    @Override
    public String getAuthority() {
        return this.nome;
    }

}
