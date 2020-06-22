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

/**
 * 
 * Construtor da classe. Super construtor da classe mãe.
 * 
 * @param nome
 * @param email
 * @param senha
 */
    public Usuario(String nome, String email, String senha) {
        super(nome, email, senha);
        
    }

    
    /** 
     * Retorna dados do Usuário, sem senha.
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "Usuario [email=" + email + ", nome=" + nome + "]";
    }


    
    /** 
     * Método da interface de Autenticação.
     * Retorna true se a senha for correta.
     * False se incorreta.
     * 
     * 
     * @return boolean
     */
    @Override
    public boolean autenticarSenha() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual a senha?");
        String senhaFinal = sc.nextLine();
        
        if (this.senha.equals(senhaFinal)){
            return true;
        }
        else {
            return false;
        }
    }

    
    
    
}