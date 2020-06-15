package br.maua.models;

import java.util.Scanner;

import br.maua.interfaces.Autenticacao;

public class Usuario extends Funcionario implements Autenticacao{
    public Usuario(String nome, String email, String senha) {
        super(nome, email, senha);
        
    }

    @Override
    public String toString() {
        return "Usuario [email=" + email + ", nome=" + nome + ", senha=" + senha + "]";
    }

    @Override
    public boolean autenticarSenha() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual a senha?");
        String senhaFinal = sc.nextLine();
        sc.close();
        if (this.getSenha().equals(senhaFinal)){
            return true;
        }
        else {
            return false;
        }
    }

    
    
    
}