package sample.teste;

import sample.model.Carta;

import java.sql.*;

public class Aplicacao {
    public Carta run(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:cartas_inicio.db");
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM cartas");
            while(result.next()){
                Carta carta = new Carta(
                        result.getString("url"),
                        result.getString("id"),
                        result.getString("colecao"),
                        result.getString("nome"),
                        result.getString("raridade"),
                        result.getString("serie")
                );
                System.out.println(carta);

                return carta;
            }
            result.close();


//            //Inserir um novo produto
//            Produto produto = new Produto("2000", "Water Cooler 120mm", "Cooler", 80, 240, 5);
//            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO produtos (codigo, nome, descricao, custo, valor, quantidade) VALUES (?, ?, ?, ?, ?, ?);");
//            preparedStatement.setString(1, produto.getCodigo());
//            preparedStatement.setString(2, produto.getNome());
//            preparedStatement.setString(3, produto.getDescricao());
//            preparedStatement.setDouble(4, produto.getCusto());
//            preparedStatement.setDouble(5, produto.getValor());
//            preparedStatement.setInt(6, produto.getQuantidade());
//            //Executa o PreparedStatement
//            int retorno = preparedStatement.executeUpdate();
//            System.out.println("Retorno:" + retorno);
//            //Salva as modificações no banco
//            //connection.commit();
//
//            //Exibe o conteúdo do banco
//            result = statement.executeQuery("SELECT * FROM produtos");
//            while(result.next()){
//                Produto newproduto = new Produto(
//                        result.getString("codigo"),
//                        result.getString("nome"),
//                        result.getString("descricao"),
//                        result.getDouble("custo"),
//                        result.getDouble("valor"),
//                        result.getInt("quantidade")
//                );
//                System.out.println(newproduto);
//            }
//            result.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

        return null;
    }
}

