package br.maua.dao;

import br.maua.model.Personagem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe modelo de Personagem<br>
 *     Implementa interfaces DAO e DAOFields
 * @author Andre Lebrao 18.00356-7
 * @author Joao Guilherme Jatoba 18.01790-8
 * @since 24/11/2020
 */
public class PersonagemDAO  implements DAO<Personagem>,DAOFields{
    private Connection connection;
    private String myDBConnectionString = "jdbc:sqlite:personagens.db";

    /**
     * Construtor da classe modelo de PersonagemDAO<br>
     *     Inicia a conexao com a tabela personagens em SQL
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
     * @return Lista de personagens
     */
    @Override
    public List<Personagem> getAll() {
        List<Personagem> personagens = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectAllString(getTableName()));
            while(result.next()){
                Personagem pers = new Personagem(
                        result.getString("nome"),
                        result.getString("raca"),
                        result.getString("prof"),
                        result.getInt("mana"),
                        result.getInt("atq"),
                        result.getInt("atqMag"),
                        result.getInt("def"),
                        result.getInt("defMag"),
                        result.getInt("vel"),
                        result.getInt("destreza"),
                        result.getInt("exp"),
                        result.getInt("nivel")
                );
                personagens.add(pers);
            }
            result.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return personagens;
    }

    @Override
    public void update(Personagem personagem, String coluna,String novoValor) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getUpdateString(getTableName(),coluna));
            if(coluna.equals("nome")||coluna.equals("raca")||coluna.equals("prof"))
                preparedStatement.setString(1, novoValor);
            else
                preparedStatement.setInt(1,Integer.parseInt(novoValor));
            preparedStatement.setString(2,personagem.getNome());
            //Executa o PreparedStatement
            int retorno = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Metodo usado para atualizar variaveis de um personagem do banco de dados
     * @param personagem Personagem que ira ter variaveis mudadas
     */
    @Override
    public void updateAll(Personagem personagem) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getUpdateAllString(getTableName()));
            preparedStatement.setString(1,personagem.getNome());
            preparedStatement.setString(2,personagem.getRaca());
            preparedStatement.setString(3,personagem.getProf());
            preparedStatement.setInt(4,personagem.getMana());
            preparedStatement.setInt(5,personagem.getAtq());
            preparedStatement.setInt(6,personagem.getAtqMag());
            preparedStatement.setInt(7,personagem.getDef());
            preparedStatement.setInt(8,personagem.getDefMag());
            preparedStatement.setInt(9,personagem.getVel());
            preparedStatement.setInt(10,personagem.getDestreza());
            preparedStatement.setInt(11,personagem.getExp());
            preparedStatement.setInt(12,personagem.getNivel());
            preparedStatement.setString(13,personagem.getNome());
            int retorno = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Classe que ira adicionar um novo personagem no banco de dados
     * @param personagem O personagem a ser adicionado no banco de dados
     */
    @Override
    public void create(Personagem personagem) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getInsertString(getTableName()));
            preparedStatement.setString(1,personagem.getNome());
            preparedStatement.setString(2,personagem.getRaca());
            preparedStatement.setString(3,personagem.getProf());
            preparedStatement.setInt(4,personagem.getMana());
            preparedStatement.setInt(5,personagem.getAtq());
            preparedStatement.setInt(6,personagem.getAtqMag());
            preparedStatement.setInt(7,personagem.getDef());
            preparedStatement.setInt(8,personagem.getDefMag());
            preparedStatement.setInt(9,personagem.getVel());
            preparedStatement.setInt(10,personagem.getDestreza());
            preparedStatement.setInt(11,personagem.getExp());
            preparedStatement.setInt(12,personagem.getNivel());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Metodo que ira deletar um persongaem do banco de dados
     * @param personagem Personagem a ser deletado
     */
    @Override
    public void delete(Personagem personagem) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getDeleteString(getTableName()));
            preparedStatement.setString(1, personagem.getNome());
            preparedStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @return Nome da tabela (personagens)
     */
    @Override
    public String getTableName() {
        return "personagens";
    }

    @Override
    public String getUpdateString(String table,String coluna) {
        return "UPDATE "+ table +" SET "+coluna+" = ? WHERE nome = ?;";
    }

    @Override
    public String getUpdateAllString(String table) {
        return "UPDATE "+ table +" SET nome = ?, raca = ?, prof = ?, mana = ?, atq = ?, atqMag = ?, def = ?, defMag =" +
                " ?, vel = ?, destreza = ?, exp = ?, nivel = ?" + " WHERE " + "nome = ?;";
    }

    /**
     *
     * @param table Nome da tabela
     * @return Frase usada em SQL para adicionar um novo elemento na tabela
     */
    @Override
    public String getInsertString(String table) {
        return "INSERT INTO "+table +" (nome,raca,prof,mana,atq,atqmag,def,defmag,vel,destreza,exp,nivel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
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

    @Override
    public String getDeleteString(String table) {
        return "DELETE FROM "+ table +" WHERE nome = ?";
    }
}
