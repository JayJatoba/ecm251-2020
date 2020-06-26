package br.maua.pizzaria;

import java.util.ArrayList;
import java.util.Scanner;

import br.maua.enums.EstadoPedido;
import br.maua.enums.TipoPagamento;
import br.maua.models.Pedido;
import br.maua.models.Usuario;

/**
 * Classe sistema 
 *      É chamada pela classe principal
 *      Interface com o usuário
 * 
 * @author João Guilherme Martins Jatobá - 18.01790-8@maua.br
 * @since 15/06/2020
 * @version 1.0
 */

public class Sistema {
    /**
     * Método que faz a conversa direta com o usuário do código.
     */
    public static void run(){
        /**
         * Variável do tipo ArrayList,
         * guarda uma lista com todos os Pedidos do sistema.
         * 
         */
        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        /**
         * Variável booleana;
         * usada para enquanto verdadeira, o sistema da
         *  pizzaria está funcionando.
         */
        boolean flag = true;
        Usuario user = new Usuario("Teste", "email_teste@teste.com", "123456");
        while (flag){
            menu();
            /**
             * Variável tipo int,
             * representa o número escolhido do 
             * menu inicial apresentado para o funcionário.
             */
            int escolha = verificacaoErros();
            switch (escolha) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    fazerPedido(listaPedidos, user);
                    break;
                case 2:
                    mostrarPedidos(listaPedidos);
                    break;
                case 3:
                    alterarEstado(listaPedidos, user);
                    break;
                case 999999:
                    System.out.println("Escolha uma das opcoes em número inteiro.");
                    break;
                default:
                    System.out.println("Valores aceitos: 0 - 1 - 2 - 3");
                    break;}}}// Fim do método run()

    /** 
     * Método usado para retornar o número da opção escolhida quando
     * são chamados os métodos: fazerPedido (escolha do pagamento) e alterarEstado (alterar estado atual do pedido).
     * 
     * @return int
     */
    public static int verificacaoErros(){
        Scanner sc = new Scanner(System.in);
        /**
         * Variável string,
         * será transformada para inteiro, e lida como 
         * escolha do menu de opções apresentado.
         */
        String opcao = sc.nextLine();
        try {
            return Integer.parseInt(opcao);}
        // Erro para opção que não é número inteiro,
        // que com default vai para 999999
        catch (NumberFormatException e)
        {
            return 999999;}}// Fim do método verificacaoErros

    /**
     * Este método é usado para criação de um pedido.
     * O sistema tem salvo uma lista de Pedidos, que é passada para
     * o método fazerPedido como parâmetro, e o pedido novo é adicionado
     * à lista.
     * O parâmetro de usuário é usado para fazer a autenticação de senha.
     * Somente quem tem a senha pode adicionar pedidos.
     * 
     * @param listaPedidos Primeiro parâmetro do método fazerPedido
     * @param user Segundo parâmetro do método fazerPedido
     */
    public static void fazerPedido(ArrayList<Pedido> listaPedidos, Usuario user){
        if(user.autenticarSenha()){
            Scanner sc = new Scanner(System.in);
            System.out.println("Qual a descrição do pedido?");
            /**
             * Variável tipo String,
             * representa a descrição do pedido a ser instanciado.
             */
            String descricao = sc.nextLine();
            System.out.println("Qual valor do pedido?");
            /**
             * Variável tipo float,
             * começa em 0 para ter valor, sendo que será mudada 
             * com o valor total do pedido
             */
            float valor = 0;
            /** 
             * Variável tipo String,
             * representa o input feito pelo funcionário
            */
            String valorStr = sc.nextLine();
            while(true){
            try {
                valor = Float.parseFloat(valorStr);
                if(valor<=0){
                    throw new IllegalArgumentException("Valor da compra tem que ser maior que 0.");
                }
                break;}
         // Erro para valor que não é número float,
         // que com default vai para 0
            catch (NumberFormatException e)
         {
                System.out.println("Digite valor em float. (Para separar as casas decimais, usar '.')");
                valorStr = sc.nextLine();}
        //  Erro para valor menor ou igual a 0. Isto não seria uma compra aceita.
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println("Qual o valor da compra? (em float e positivo)");
                valorStr = sc.nextLine();
            }}// final do while para pedir valor.
        
            System.out.println("Opções de pagamento:\n1 - Dinheiro");
            System.out.println("2 - Débito\n3 - Crédito\n4 - Vale Alimentação");
            System.out.println("5 - Vale Refeição");
            
            boolean flag2 = true;
            int metodo=0;
            // Início do switch case de leitura do tipo de pagamento.
            while(flag2){
                metodo = verificacaoErros();
                switch (metodo) {
                    case 1:
                        listaPedidos.add(new Pedido(descricao, valor, TipoPagamento.DINHEIRO));
                        System.out.println("Pedido realizado.");
                        flag2 = false;
                        break;
                    case 2:
                        listaPedidos.add(new Pedido(descricao, valor, TipoPagamento.DEBITO));
                        System.out.println("Pedido realizado.");
                        flag2 = false;
                        break;
                    case 3:
                        listaPedidos.add(new Pedido(descricao, valor, TipoPagamento.CREDITO));
                        System.out.println("Pedido realizado.");
                        flag2 = false;
                        break;
                    case 4:
                        listaPedidos.add(new Pedido(descricao, valor, TipoPagamento.VALE_ALIMENTACAO));
                        System.out.println("Pedido realizado.");
                        flag2 = false;
                        break;
                    case 5:
                        listaPedidos.add(new Pedido(descricao, valor, TipoPagamento.VALE_REFEICAO));
                        System.out.println("Pedido realizado.");
                        flag2 = false;
                        break;           
                    default:
                        System.out.println("Valores aceitos somente de 1 a 5.");
                        break;}
            }}//Final do if de senha aceita
        else{
            System.out.println("Autorização negada.");
        }}// Fim do método fazerPedido()

    /** 
     * Método que irá mudar o estado de pedidos da lista do sistema.
     * Recebe como parâmetros a lista do sistema, e o usuário que deve autenticar sua senha,
     * já que não é qualquer pessoa que pode mudar o estado de pedidos.
     * 
     * @param listaPedidos
     * @param user
     */
    public static void alterarEstado(ArrayList<Pedido> listaPedidos, Usuario user){
        if(verificaLista(listaPedidos)){
            if (user.autenticarSenha()){
                Scanner sc = new Scanner(System.in);
                mostrarPedidos(listaPedidos);
                System.out.println("Qual o id do pedido a ser alterado?");
                /**
                 * Variável tipo String,
                 * representa o id pedido
                 */
                String idPedido = sc.nextLine();
                /**
                 * Variável booleana,
                 * representa se alteração do estado foi bem sucedida
                 */
                boolean alteracao = false;
                for (Pedido pedido : listaPedidos) {
                    if(pedido.getId().equals(idPedido)){
                        alteracao = true;
                        System.out.println("Estado para ser mudado:\n1 - PREPARACAO");
                        System.out.println("2 - SAIU_PARA_ENTREGA\n3 - ENTREGUE\n4 - DEVOLVIDO");
                        /**
                         * Variável booleana,
                         * usada na função while
                         */
                        boolean flag2 = true;
                        /**
                         * Variável tipo int,
                         * representa a escolha do método
                         */
                        int metodo=0;
                        while(flag2){
                            metodo = verificacaoErros();
                            switch (metodo) {
                                case 1:
                                    pedido.setEstadoPedido(EstadoPedido.PREPARACAO);
                                    flag2 = false;
                                    break;
                                case 2:
                                    pedido.setEstadoPedido(EstadoPedido.SAIU_PARA_ENTREGA);
                                    flag2 = false;
                                    break;
                                case 3:
                                    pedido.setEstadoPedido(EstadoPedido.ENTREGUE);
                                    flag2 = false;
                                    break;
                                case 4:
                                    pedido.setEstadoPedido(EstadoPedido.DEVOLVIDO);
                                    flag2 = false;
                                    break;
                        
                                default:
                                    System.out.println("Valores aceitos somente de 1 a 4, inteiro.\nQual sua escolha?");

                                    break;}}// Fim do while
                        System.out.println("Estado do pedido alterado.");
                        break;}  
            }//Termina o foreach
                if (!alteracao){
                    System.out.println("Pedido com id = "+idPedido+" não encontrado.");}    
        }// Final do if de senha aceita
            else{
                System.out.println("Autorização negada para trocar estado de pedido.");} 
        }// Lista não está vazia
        else{
            System.out.println("Lista está vazia.");}
        }// Fim do método alterarEstado()
         
    /** 
     * Método booleano que recebe a lista de pedidos do sistema.
     * Retorna true se a lista está vazia.
     * False se tem algum elemento.
     * 
     * @param listaPedidos
     * @return boolean
     */
    public static boolean verificaLista(ArrayList<Pedido> listaPedidos){
        if (listaPedidos.isEmpty()){
            return false;}
        return true;}// Fim do método verficaLista()

    /** 
     * Método void, que imprime a lista de pedidos (único parâmetro)
     * quando não está vazia.
     * Se vazia, imprime a informação de que está vazia.
     * Recebe a lista de pedidos do sistema.
     * 
     * @param listaPedidos único parâmetro
     */
    public static void mostrarPedidos(ArrayList<Pedido> listaPedidos){
        if (verificaLista(listaPedidos)){
            for (Pedido pedido : listaPedidos) {
                System.out.println("\n"+pedido.toString()+"\n");}
        }
        else{
            System.out.println("Lista de pedidos está vazia.");}
        }// Fim do método mostrarPedidos()

    /**
     * Método que imprime o menu de opções do sistema.
     * Interface gráfica inicial.
     * 
     */
    public static void menu(){
        System.out.println("Pizzaria o Rato que Ri:\n1 - Nova venda\n2 - Verificar pedidos\n3 - Alterar pedidos\n0 - Sair");
    }
}