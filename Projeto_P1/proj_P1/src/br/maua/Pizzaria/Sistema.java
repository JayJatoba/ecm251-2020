package br.maua.Pizzaria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import br.maua.enums.EstadoPedido;
import br.maua.enums.TipoPagamento;
import br.maua.models.Pedido;
import br.maua.models.Usuario;

public class Sistema {
    private static final String senha = "123456";

    public static void run(){
        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        boolean flag = true;
        Usuario user = new Usuario("MZ", "mz@email.com", senha);
        
        
        while (flag){
            menu();
            Scanner sc = new Scanner(System.in);
            String opcao = sc.nextLine();

            int escolha;
            try {
               escolha = Integer.parseInt(opcao);
        }
        // Erro para opção que não é número inteiro,
        // que com default vai para 999999
            catch (NumberFormatException e)
        {
               escolha = 999999;
        }

            switch (escolha) {
                case 1:
                if(user.autenticarSenha()){
                    System.out.println("Qual a descrição do pedido?");
                    String descricao = sc.nextLine();
                    System.out.println("Qual valor do pedido?");
                    float valor;
                    String valorStr = sc.nextLine();
                    while(true){
                    try {
                        valor = Float.parseFloat(valorStr);
                        break;
                 }
                 // Erro para valor que não é número float,
                 // que com default vai para 0
                    catch (NumberFormatException e)
                 {
                        System.out.println("Digite valor em float.");
                        valorStr = sc.nextLine();
                 }}

                
                    System.out.println("Opções de pagamento:\n1 - Dinheiro");
                    System.out.println("2 - Débito\n3 - Crédito\n4 - Vale Alimentação");
                    System.out.println("5 - Vale Refeição");
                    
                    boolean flag2 = true;
                    int metodo=0;
                    while(flag2){
                        opcao = sc.nextLine();
                        
                        try {
                            metodo = Integer.parseInt(opcao);
}
                        catch (NumberFormatException e){
                            metodo = 0;}
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
                    }
                    
                        
                }//Final do if de senha aceita
                else{
                    System.out.println("Autorização negada.");
                }
                    

                    break;

                case 2:
                    mostrarPedidos(listaPedidos);
                    break;

                case 3:

                    if(verificaLista(listaPedidos)){
                        if (user.autenticarSenha()){
                            mostrarPedidos(listaPedidos);
                            System.out.println("Qual o id do pedido a ser alterado?");
                            String idPedido = sc.nextLine();
                            boolean alteracao = false;
                            for (Pedido pedido : listaPedidos) {
                                if(pedido.getId().equals(idPedido)){
                                    alteracao = true;
                                    System.out.println("Estado para ser mudado:\n1 - PREPARACAO");
                                    System.out.println("2 - SAIU_PARA_ENTREGA\n3 - ENTREGUE\n4 - DEVOLVIDO");
                                
                                    boolean flag2 = true;
                                    int metodo=0;
                                    while(flag2){
                                        opcao = sc.nextLine();
                                    
                                        try {
                                            metodo = Integer.parseInt(opcao);}
                                        catch (NumberFormatException e){
                                            metodo = 0;}
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
                                            System.out.println("Valores aceitos somente de 1 a 4.");
                                            break;}
                                        System.out.println("Estado do pedido alterado.");
                                break;}}//Termina o foreach
                            
                        }
                            if (!alteracao){
                                System.out.println("Pedido com id = "+idPedido+" não encontrado.");
                            }    
                    }// Final do if de senha aceita
                        else{
                            System.out.println("Autorização negada para trocar estado de pedido.");
                        } 
                    }   // Lista não está vazia
                    else{
                        System.out.println("Lista está vazia.");
                    }
                    
                    break;

                case 0:
                    flag = false;
                    break;

                case 999999:
                    System.out.println("Escolha uma das opcoes em número inteiro.");
                    break;
        
                default:
                
                    break;}}
        
    }





    // public void alterarEstado(){
    //     // Para alterar estados de pedidos,
    //     // deve-se ver se há pedidos.

    //     if (verificaLista()){

    //     }
    //     else{
    //         System.out.println("Não há pedidos para mudar.");
    //     }
    // }
        

    public static boolean verificaLista(ArrayList<Pedido> listaPedidos){
        if (listaPedidos.isEmpty()){
            return false;
        }
        return true;
    } 

    public static void mostrarPedidos(ArrayList<Pedido> listaPedidos){
        if (verificaLista(listaPedidos)){
            for (Pedido pedido : listaPedidos) {
                System.out.println("\n"+pedido.toString()+"\n"); 
            }
        }
        else{
            System.out.println("Lista de pedidos vazia.");
        }
        
    }

    public static void menu(){
        System.out.println("Pizzaria o Rato que Ri:\n1 - Nova venda\n2 - Verificar pedidos\n3 - Alterar pedidos\n0 - Sair");
    }

}