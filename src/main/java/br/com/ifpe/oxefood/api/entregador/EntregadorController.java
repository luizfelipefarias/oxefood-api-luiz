package br.com.ifpe.oxefood.api.entregador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import br.com.ifpe.oxefood.modelo.entregador.EntregadorService;



// Indica que esta classe é um controlador REST 
//O Spring vê que o controlador é um @RestController → serializa o objeto entregador para JSON automaticamente usando Jackson.
//Spring Boot usa Jackson nos bastidores para enviar e receber JSON automaticamente.
//Jackson é uam biblioteca q já vem integrada e serve para converter o objeto Java em JSON e Json em java/ faz serialização e desserialização de JSON

@RestController // @RestController = @Controller + @ResponseBody

// Define o caminho base da API para esta classe
// Todas as rotas começam com /api/entregador
@RequestMapping("api/entregador")


// Permite que aplicações de outros domínios acessem esta API (CORS)
@CrossOrigin
public class EntregadorController {
    @Autowired
    private EntregadorService entregadorService;
    
    // Define que este método responde a requisições POST
    @PostMapping
    
    //
    //-ResponseEntity<Entregador> é o tipo de retorno do método.

    //-ResponseEntity → significa que você não vai devolver só o objeto, mas uma resposta HTTP completa podendo conter status http,corpo de resposta e cabeçalhos extras como Location, content-type e etc.Caso tu use no retorno um ResponseEntity<T>

    //-<Entregador> → indica o tipo do corpo da resposta (o conteúdo que vai dentro do ResponseEntity).

    //-O @RequestBody faz o Spring pegar o JSON do corpo da requisição e converter em objeto Java do tipo EntregadorRequest.
    public ResponseEntity<Entregador> save(@RequestBody EntregadorRequest entregadorRequest){

        // O entregadorRequest é um objeto da classe EntregadorRequest, criado a partir do JSON da requisição

        // Ele possui o método "build()", que cria e retorna um objeto da entidade Entregador com os dados contidos no DTO

        // Salvamos essa entidade no banco através do entregadorService

        // O objeto salvo é armazenado em uma variável para ser retornado na resposta HTTP com status 201 CREATED

        Entregador entregador = entregadorService.save(entregadorRequest.build());

        return new ResponseEntity<Entregador>(entregador,HttpStatus.CREATED);
    }

    @GetMapping
    public List<Entregador> listarTodos(){
        return entregadorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Entregador obterPorId (@PathVariable Long id) {
        return entregadorService.obterPorId(id);
    }
    

}
