package br.maua.model;

import java.util.Scanner;

public class CLI {
    private static boolean flag=true;

    private static void run(){
        Scanner sc = new Scanner(System.in);
        int opcao;
        while(flag){
            System.out.println("1 - Criar novo personagem\n2 - Alterar personagem existente\n3 - Consultar personagens existentes\n4 - Deletar personagem\n0 - Sair");
            opcao = sc.nextInt();
            sc.nextLine();
            switch(opcao){
                case 1:
                    criacao();
                case 2:
                case 3:
                case 4:
                case 0:
                    flag=false;
                    break;
                default:
                    break;

            }
        }
    }
    private static void criacao(){

    }
    private static void alterar(){

    }
    private static void deletar(){

    }
}
