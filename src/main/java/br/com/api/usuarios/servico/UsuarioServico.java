package br.com.api.usuarios.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.usuarios.modelo.RespostaModelo;
import br.com.api.usuarios.modelo.UsuarioModelo;
import br.com.api.usuarios.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServico {

    @Autowired
    private UsuarioRepositorio ur;

    @Autowired
    private RespostaModelo rm;

    // Método para listar todos os produtos
    public Iterable<UsuarioModelo> listar(){
        return ur.findAll();
    }

    // Método para cadastrar ou alterar usuarios
    public ResponseEntity<?> cadastrarAlterar(UsuarioModelo um, String acao){

        if(um.getNome().equals("")){
            rm.setMensagem("O nome é obrigatótio!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else if(um.getCpf().equals("")){
            rm.setMensagem("O CPF é obrigatótio!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else if(um.getRg().equals("")){
            rm.setMensagem("O RG é obrigatótio!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else if(um.getDate_nascimento().equals("")){
            rm.setMensagem("A data de nascimento é obrigatótio!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else if(um.getMae().equals("")){
            rm.setMensagem("O nome da mãe é obrigatótio!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else{
            if(acao.equals("cadastrar")){
                return new ResponseEntity<UsuarioModelo>(ur.save(um), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<UsuarioModelo>(ur.save(um), HttpStatus.OK);
            }
        }

    }

    // Método para remover usuario
    public ResponseEntity<RespostaModelo> remover(String cpf){
        ur.deleteById(cpf);
        rm.setMensagem("Usuario removido co sucesso");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);
    }
}
