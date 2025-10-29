package br.com.ifpe.oxefood.api.estado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.estado.Estado;
import br.com.ifpe.oxefood.modelo.estado.EstadoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/estado")
@CrossOrigin(origins = "*")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;
    
    @PostMapping
    public ResponseEntity<Estado> save(@RequestBody EstadoRequest estadoRequest) {

        Estado estado = estadoService.save(estadoRequest.build());
        return new ResponseEntity<Estado>(estado, HttpStatus.CREATED);
    }
    

    @GetMapping
    public List<Estado> listarTodos() {
        return estadoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Estado obterPorID(@PathVariable Long id) {
        return estadoService.obterPorID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> alterar(@PathVariable("id") Long id, @RequestBody EstadoRequest estadoRequest) {
        
        estadoService.update(id, estadoRequest.build());

        
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {

        estadoService.delete(id);

        return ResponseEntity.ok().build();
    }
    
}
