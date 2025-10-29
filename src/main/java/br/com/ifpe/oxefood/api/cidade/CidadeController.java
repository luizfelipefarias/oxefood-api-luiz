package br.com.ifpe.oxefood.api.cidade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.cidade.Cidade;
import br.com.ifpe.oxefood.modelo.cidade.CidadeService;
import br.com.ifpe.oxefood.modelo.estado.EstadoService;


import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/cidade")
@CrossOrigin
public class CidadeController {
    
    @Autowired
    private CidadeService cidadeService;

    @Autowired
    private EstadoService estadoService;

    @PostMapping
    public ResponseEntity<Cidade> save(@RequestBody CidadeRequest  cidadeRequest) {
        Cidade cidadeNova = cidadeService.save(cidadeRequest.build());
        cidadeNova.setEstado(estadoService.obterPorID(cidadeRequest.getIdEstado()));

        Cidade cidade = cidadeService.save(cidadeNova);
        
        return new ResponseEntity<Cidade>(cidade, HttpStatus.CREATED);
    }
    
    @GetMapping
    public List<Cidade> listarTodos() {
        return cidadeService.listarTodos();
    }

    @GetMapping("/{id}")
    public Cidade obterPorID(@PathVariable Long id) {
        return cidadeService.obterPorID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cidade> putMethodName(@PathVariable Long id, @RequestBody CidadeRequest cidadeRequest) {

        Cidade cidade = cidadeRequest.build();
        cidade.setEstado(estadoService.obterPorID(cidadeRequest.getIdEstado()));

        cidadeService.update(id, cidade);
        
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        cidadeService.delete(id);

        return ResponseEntity.ok().build();
    }
}
