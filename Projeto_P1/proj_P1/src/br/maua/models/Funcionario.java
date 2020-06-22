package br.maua.models;

/**
 * 
 * Classe abstrata de funcionario.
 * Qualquer trabalhador é um funcionário, logo qualquer
 * classe que é de trabalhador, estende Funcionario.
 * 
 * @author João Guilherme Martins Jatobá - 18.01790-8@maua.br
 * @since 15/06/2020
 * @version 1.0
 */

public abstract class Funcionario {
    protected String nome;
    protected String email;
    protected String senha;



/**
 * 
 * Método construtor da classe Funcionario
 * Recebe como parâmetroes nome, email e senha.
 * Iniciado quando qualquer classe filha é instanciada.
 * 
 * @param nome
 * @param email
 * @param senha
 */
    public Funcionario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }


    
    /** 
     * Método que retorna o nome do funcionário.
     * 
     * @return String
     */
    public String getNome() {
        return nome;
    }

    

    
    /** 
     * 
     * Método que retorna o email do funcionário
     * 
     * @return String
     */
    public String getEmail() {
        return email;
    }
    
}