package br.maua.model;

import br.maua.enums.Profissoes;
import br.maua.enums.Racas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CLI {
    private static boolean flag=true;
    private static Scanner sc = new Scanner(System.in);
    private static List<Personagem> lista = new ArrayList<>();
    public static void run(){

        int opcao;
        while(flag){
            System.out.println("1 - Criar novo personagem\n2 - Alterar personagem existente\n3 - Consultar personagens existentes\n4 - Deletar personagem\n0 - Sair");
            opcao = sc.nextInt();
            sc.nextLine();
            switch(opcao){
                case 1:
                    criacao();
                    break;
                case 2:
                    alterar();
                    break;
                case 3:
                    consultar();
                    break;
                case 4:
                    deletar();
                    break;
                case 0:
                    flag=false;
                    break;
                default:
                    break;

            }
        }
    }
    private static void criacao(){
        System.out.println("Nome do personagem:");
        String nome =sc.nextLine();
        for (Personagem personagem:
                lista) {
            if (personagem.getNome().equals(nome)){
                System.out.println("Personagem com esse nome ja existente");
                return;
            }
        }
        Racas raca=escolherRaca();
        Profissoes prof = escolherProfissao();

        lista.add(new Personagem(nome, raca, prof, pegarValor("Mana"),pegarValor("Ataque"),pegarValor("Ataque Magico"),pegarValor("Defesa"),pegarValor("Defesa Magica"),pegarValor("Velocidade"),pegarValor("Destreza"),pegarValor("Experiencia"),pegarValor("Nivel")));
    }
    private static void alterar(){
        System.out.println("Alterando");
    }
    private static void consultar(){
        System.out.println("Consultando");

        for (Personagem personagem:
             lista) {
            System.out.println(personagem);
        }
    }
    private static void deletar(){
        System.out.println("Deletar");
        for (Personagem personagem:
                lista) {
            System.out.println(personagem.getNome());
        }
        System.out.println("Nome para deletar: ");
        String nome = sc.nextLine();
        for (Personagem personagem:
                lista) {
            if (personagem.getNome().equals(nome)){
                lista.remove(personagem);
                System.out.println(personagem.getNome()+" deletado com sucesso");
                return;
            }
        }
        System.out.println("Personagem com nome: \'"+nome+"\' nao encontrado");
    }
    private static Racas escolherRaca(){
        System.out.println("Escolha a sua raca: \n1- Humano\n2- Anao\n3- Dahllan\n4- Elfo\n5- Goblin\n6- Lefou\n7- Minotauro\n8- Qareen\n9- Golem \n10- Hynne\n11- Kliren\n12- Medusa\n13- Osteon\n14- Silfide\n15- Suraggel\n16- Trog");
        int opcao = sc.nextInt();
        switch (opcao){
            case 1:
                return Racas.HUMANO;
            case 2:
                return Racas.ANAO;
            case 3:
                return Racas.DAHLLAN;
            case 4:
                return Racas.ELFO;
            case 5:
                return Racas.GOBLIN;
            case 6:
                return Racas.LEFOU;
            case 7:
                return Racas.MINOTAURO;
            case 8:
                return Racas.QAREEN;
            case 9:
                return Racas.GOLEM;
            case 10:
                return Racas.HYNNE;
            case 11:
                return Racas.KLIREN;
            case 12:
                return Racas.MEDUSA;
            case 13:
                return Racas.OSTEON;
            case 14:
                return Racas.SILFIDE;
            case 15:
                return Racas.SURAGGEL;
            case 16:
                return Racas.TROG;
            default:
                return escolherRaca();
        }
    }
    private  static Profissoes escolherProfissao(){
        System.out.println("Escolah sua profissao: \n1- Arcanista\n2- Barbaro\n3- Bardo\n4- Bucaneiro\n5- Cacador\n6- Cavaleiro\n7- Clerigo\n8- Druida\n9- Guerreiro\n10- Inventor\n11- Ladino\n12- Lutador\n13- Nobre\n14- Paladino");
        int opcao = sc.nextInt();
        switch (opcao){
            case 1:
                return Profissoes.ARCANISTA;
            case 2:
                return Profissoes.BARBARO;
            case 3:
                return Profissoes.BARDO;
            case 4:
                return Profissoes.BUCANEIRO;
            case 5:
                return Profissoes.CACADOR;
            case 6:
                return Profissoes.CAVALEIRO;
            case 7:
                return Profissoes.CLERIGO;
            case 8:
                return Profissoes.DRUIDA;
            case 9:
                return Profissoes.GUERREIRO;
            case 10:
                return Profissoes.INVENTOR;
            case 11:
                return Profissoes.LADINO;
            case 12:
                return Profissoes.LUTADOR;
            case 13:
                return Profissoes.NOBRE;
            case 14:
                return Profissoes.PALADINO;
            default:
                return escolherProfissao();
        }
    }
    private static int pegarValor(String tipo){
        System.out.println("Digite o valor (sempre maior que 0) do atributo: "+tipo);
        int valor = sc.nextInt();
        if (valor<0){
            return pegarValor(tipo);
        }
        return valor;
    }
}
