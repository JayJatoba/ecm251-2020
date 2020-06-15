package br.maua.Pizzaria;

import java.util.Scanner;

public class Sistema {
    public static void run(){
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




        

        
    }

    public static void menu(){
        System.out.println("Pizzaria o Rato que Ri:\n1 - Nova venda\n2 - Verificar pedidos\n3 - Alterar pedidos\n0 - Sair");
    }
}