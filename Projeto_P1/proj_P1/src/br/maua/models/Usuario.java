package br.maua.models;

import java.util.Scanner;

import br.maua.interfaces.Autenticacao;

/**
 * 
 * Classe concreta que representa um usuário.
 * Define a forma como um usuário é visto pelo sistema.
 * 
 * Estende a classe Funcionario e assina o contrato
 * com a interface de Autenticacao.
 * 
 * @author João Guilherme Martins Jatobá - 18.01790-8@maua.br
 * @since 15/06/2020
 * @version 1.0
 */

public class Usuario extends Funcionario implements Autenticacao{


    public Usuario(String nome, String email, String senha) {
        super(nome, email, senha);
        
    }

    @Override
    public String toString() {
        return "Usuario [email=" + email + ", nome=" + nome + "]";
    }


    // TODO Pensar se autenticar é de usuário ou Funcionário.
    @Override
    public boolean autenticarSenha() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual a senha?");
        String senhaFinal = sc.nextLine();
        
        if (this.getSenha().equals(senhaFinal)){
            return true;
        }
        else {
            return false;
        }
    }

    
    
    
}