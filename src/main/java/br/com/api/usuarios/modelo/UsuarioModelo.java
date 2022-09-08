package br.com.api.usuarios.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class UsuarioModelo {
    
    @Id
    private String cpf;
    private String nome;
    private String rg;
    private String mae;
    private String date_nascimento;
    private String date_cadastro;

}
