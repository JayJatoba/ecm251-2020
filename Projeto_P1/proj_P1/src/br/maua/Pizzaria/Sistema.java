package br.maua.Pizzaria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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

                    
                    String[] opcoesPagar= new String[]{"1","2","3","4","5"};
                    System.out.println("Opções de pagamento:\n1 - Dinheiro");
                    System.out.println("2 - Débito\n3 - Crédito\n4 - Vale Alimentação");
                    System.out.println("5 - Vale Refeição");
                    opcao = "";
                    while(true && !Arrays.asList(opcoesPagar).contains(opcao)){
                        
                        try {
                            escolha = Integer.parseInt(opcao);
                            break;
                     }
                     // Erro para valor que não é número float,
                     // que com default vai para 0
                        catch (NumberFormatException e)
                     {
                            System.out.println("Digite opcao (1 a 5).");
                            opcao = sc.nextLine();
                            
                     }}
                    
                    switch (escolha) {
                        case 1:
                            listaPedidos.add(new Pedido(descricao, valor, TipoPagamento.DINHEIRO));
                            break;
                        case 2:
                            listaPedidos.add(new Pedido(descricao, valor, TipoPagamento.DEBITO));
                            break;
                        case 3:
                            listaPedidos.add(new Pedido(descricao, valor, TipoPagamento.CREDITO));
                            break;
                        case 4:
                            listaPedidos.add(new Pedido(descricao, valor, TipoPagamento.VALE_ALIMENTACAO));
                            break;
                        case 5:
                            listaPedidos.add(new Pedido(descricao, valor, TipoPagamento.VALE_REFEICAO));
                            break;
                        
                        default:
                            break;}
                        System.out.println("Pedido realizado.");

                    break;

                case 2:
                    mostrarPedidos(listaPedidos);
                    break;

                case 3:
                        
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