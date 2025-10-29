package br.com.ifpe.oxefood.api.funcionario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.acesso.Usuario;
import br.com.ifpe.oxefood.modelo.funcionario.Funcionario;
import br.com.ifpe.oxefood.modelo.funcionario.FuncionarioService;
import br.com.ifpe.oxefood.modelo.funcionario.TipoFuncionario;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/funcionario")
@CrossOrigin
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<Funcionario> save(@RequestBody @Valid FuncionarioRequest request) {

        Funcionario funcionarioNovo = request.build();
        Funcionario funcionario = funcionarioService.save(funcionarioNovo);
        return new ResponseEntity<Funcionario>(funcionario, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Funcionario> listarTodos() {

        return funcionarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Funcionario obterPorID(@PathVariable Long id) {

        return funcionarioService.obterPorID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> update(@PathVariable("id") Long id, @RequestBody FuncionarioRequest request) {

        funcionarioService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        funcionarioService.delete(id);
        return ResponseEntity.ok().build();
    }

}
