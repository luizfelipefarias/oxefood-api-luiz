package br.com.ifpe.oxefood.modelo.entregador;
// Importa a interface que tem os métodos prontos (save, findAll, etc.)
import org.springframework.data.jpa.repository.JpaRepository;
// Interface que representa o repositório de Entregador
// <Entregador, Long> significa:
// - Entregador = a entidade que será manipulada
// - Long = o tipo do campo "id" (chave primária)
//OBS: o repository tem que ser uma inteface
public interface EntregadorRepository extends JpaRepository<Entregador, Long> {
    
}
