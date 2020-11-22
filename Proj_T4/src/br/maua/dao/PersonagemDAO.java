package br.maua.dao;

import br.maua.model.Personagem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe modelo de Anime<br>
 *     Implementa interfaces DAO e DAOFields
 * @author Andre Lebrao 18.00356-7
 * @author Joao Guilherme Jatoba 18.01790-8
 * @since 28/09/2020
 */
public class PersonagemDAO  implements DAO<Personagem>,DAOFields{
    private Connection connection;
    private String myDBConnectionString = "jdbc:sqlite:weeb.db";

    /**
     * Construtor da classe modelo de AnimeDAO<br>
     *     Inicia a conexao com a tabela anime em SQL
     */
    public PersonagemDAO(){
        try {
            connection = DriverManager.getConnection(myDBConnectionString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    /**
     * Classe de retorno de lista
     * @return Lista de animes
     */
    @Override
    public List<Personagem> getAll() {
        return null;
    }




    @Override
    public void update(Personagem personagem, String idOriginal) {

    }
    /**
     * Classe que ira adicionar um novo personagem no banco de dados
     * @param personagem O personagem a ser adicionado no banco de dados
     */
    @Override
    public void create(Personagem personagem) {

    }





    /**
     * Metodo que ira verificar a existencia de um anime na tabela no banco de dados
     * @param novoNome Nome do novo anime
     * @return true se ja existir anime no banco, false se nao existir
     */


    /**
     *
     * @return Nome da tabela (personagens)
     */
    @Override
    public String getTableName() {
        return "personagens";
    }

    @Override
    public String getUpdateString(String table) {
        return null;
    }

    /**
     *
     * @param table Nome da tabela
     * @return Frase usada em SQL para adicionar um novo elemento na tabela
     */
    @Override
    public String getInsertString(String table) {
        return "INSERT INTO "+table +" (nome,raca,profissao,mana,ataque,ataquemagico,defesa,defesamagica, velocidade,destreza,experiencia,nivel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
    }

    /**
     *
     * @param table Nome da tabela
     * @return Frase usada em SQL para recuperar os dados da tabela
     */
    @Override
    public String getSelectAllString(String table) {
        return "SELECT * FROM " + table;
    }
}
