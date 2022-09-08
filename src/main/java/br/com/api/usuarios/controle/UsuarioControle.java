package br.com.api.usuarios.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.usuarios.modelo.RespostaModelo;
import br.com.api.usuarios.modelo.UsuarioModelo;
import br.com.api.usuarios.servico.UsuarioServico;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioControle {

    @Autowired
    private UsuarioServico us;

    @DeleteMapping("/remover/{cpf}")
    public ResponseEntity<RespostaModelo> excluir(@PathVariable String cpf){
        return us.remover(cpf);
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody UsuarioModelo um){
        return us.cadastrarAlterar(um, "alterar");
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody UsuarioModelo um){
        return us.cadastrarAlterar(um, "cadastrar");
    }

    @GetMapping("/listar")
    public Iterable<UsuarioModelo> listar(){
        return us.listar();
    }
    
    @GetMapping("/")
    public String rota(){
        return "API de usuarios funcionando";
    }

}
