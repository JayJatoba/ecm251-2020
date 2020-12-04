package br.maua.model;

import br.maua.dao.PersonagemDAO;
import br.maua.enums.Profissoes;
import br.maua.enums.Racas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Responsavel pela interface com o usuario
 * @author Andre Lebrao 18.00356-7
 * @author Joao Guilherme Jatoba 18.01790-8
 * @since 24/11/2020
 */

public class CLI {
    private static boolean flag=true;
    private static final Scanner sc = new Scanner(System.in);
    private static List<Personagem> lista = new ArrayList<>();
    private static final PersonagemDAO pDAO = new PersonagemDAO();

    /**
     * Metodo que sera a implementacao da interface que o usuario vera
     */
    public static void run(){
        lista = pDAO.getAll();
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
                    if(lista.isEmpty())
                        System.out.println("Ainda não há nenhum personagem para se alterar...");
                    else
                        alterar();
                    break;
                case 3:
                    if(lista.isEmpty())
                        System.out.println("Ainda não há nenhum personagem para se consultar...");
                    else
                        consultar();
                    break;
                case 4:
                    if(lista.isEmpty())
                        System.out.println("Ainda não há nenhum personagem para se deletar...");
                    else {
                        System.out.println("Nome: ");
                        deletar(sc.nextLine());

                    }
                    break;
                case 0:
                    flag=false;
                    break;
                default:
                    break;

            }
        }
    }

    /**
     * Metodo para adicionar um personagem novo ao banco de dados
     */
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
        Racas raca = escolherRaca();
        Profissoes prof = escolherProfissao();

//        lista.add(new Personagem(nome, raca, prof, pegarValor("Mana"),pegarValor("Ataque"),pegarValor("Ataque Magico"),pegarValor("Defesa"),pegarValor("Defesa Magica"),pegarValor("Velocidade"),pegarValor("Destreza"),pegarValor("Experiencia"),pegarValor("Nivel")));
        pDAO.create(new Personagem(nome, raca, prof, pegarValor("Mana"),pegarValor("Ataque"),pegarValor("Ataque Magico"),pegarValor("Defesa"),pegarValor("Defesa Magica"),pegarValor("Velocidade"),pegarValor("Destreza"),pegarValor("Experiencia"),pegarValor("Nivel")));
        lista = pDAO.getAll();
    }

    /**
     * Metodo que fara uma alteracao nos dados de um persongaem especificado pelo usuario
     */
    private static void alterar(){
        boolean flagAlterar = false;
        Personagem personagemAlterar = null;
        String nomeOriginal = null;
        System.out.println("Nome do personagem: ");
        String nome = sc.nextLine();
        for (Personagem personagem :
                lista) {
            if(personagem.getNome().equals(nome)) {
                flagAlterar = true;
                personagemAlterar = personagem;
                nomeOriginal = personagem.getNome();
                break;
            }

        }
        if(!flagAlterar)
            System.out.println("Personagem não existe\n");
        while(flagAlterar){
            System.out.println("Escolha o que alterar");
            System.out.println("1 - Nome\n2 - Raca\n3 - Profissão\n4 - Mana\n5 - Ataque\n6 - Ataque Mágico\n7 - " +
                    "Defesa\n8 - Defesa Mágica\n9 - Velocidade\n10 - Destreza\n11 - Experiência\n12 - Nível\n0 - Sair");
            int opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao){
                case 1:
                    System.out.println("Novo nome: ");
                    personagemAlterar.setNome(sc.nextLine());
                    break;
                case 2:
                    personagemAlterar.setRaca(escolherRaca().toString());
                    break;
                case 3:
                    personagemAlterar.setProf(escolherProfissao().toString());
                    break;
                case 4:
                    personagemAlterar.setMana(pegarValor("Mana"));
                    break;
                case 5:
                    personagemAlterar.setAtq(pegarValor("Ataque"));
                    break;
                case 6:
                    personagemAlterar.setAtqMag(pegarValor("Ataque Mágico"));
                    break;
                case 7:
                    personagemAlterar.setDef(pegarValor("Defesa"));
                    break;
                case 8:
                    personagemAlterar.setDefMag(pegarValor("Defesa Mágica"));
                    break;
                case 9:
                    personagemAlterar.setVel(pegarValor("Velocidade"));
                    break;
                case 10:
                    personagemAlterar.setDestreza(pegarValor("Destreza"));
                    break;
                case 11:
                    personagemAlterar.setExp(pegarValor("EXP"));
                    break;
                case 12:
                    personagemAlterar.setNivel(pegarValor("Nível"));
                    break;
                case 0:
                    flagAlterar = false;
                    break;
            }
        }

        if(nomeOriginal.equals(personagemAlterar.getNome()))
            pDAO.updateAll(personagemAlterar);
        else{
            deletar(personagemAlterar.getNome());
//            lista.add(personagemAlterar);
            pDAO.create(personagemAlterar);
        }
        lista = pDAO.getAll();
    }

    /**
     * Metodo que ira imprimir na linha de comando todos os personagens existentes na lista do banco de dados
     */
    private static void consultar(){
        System.out.println("Consultando");

        for (Personagem personagem:
             lista) {
            System.out.println(personagem);
        }
    }

    /**
     * Metodo que ira deletar da lsita do banco de dados um personagem especificado pelo usuario.
     *
     * @param nome Nome do personagem a ser deletado
     */
    private static void deletar(String nome){
        for (Personagem personagem:
                lista) {
            if (personagem.getNome().equals(nome)){
                pDAO.delete(personagem);
                lista = pDAO.getAll();
                System.out.println(personagem.getNome()+" deletado com sucesso");
                return;
            }
        }
        System.out.println("Personagem com nome: \'"+nome+"\' nao encontrado");
    }

    /**
     * Metodo que implementa um switch case com todas as escolhas de raca possivel
     * @return Raca escolhida
     */
    private static Racas escolherRaca(){
        System.out.println("Escolha a sua raca: \n1- Humano\n2- Anao\n3- Dahllan\n4- Elfo\n5- Goblin\n6- Lefou\n7- Minotauro\n8- Qareen\n9- Golem \n10- Hynne\n11- Kliren\n12- Medusa\n13- Osteon\n14- Silfide\n15- Suraggel\n16- Trog");
        int opcao = sc.nextInt();
        sc.nextLine();
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

    /**
     * Metodo que implementa um switch case com todas as escolhas de profissao possivel
     * @return Profissao escolhida
     */
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

    /**
     * Metodo para atribuir um valor ao atributo parametro
     * @param tipo Qual atributo esta ganhando um valor representativo
     * @return Numero inteiro que representa o valor do atributo em questao
     */
    private static int pegarValor(String tipo){
        System.out.println("Digite o valor (sempre maior que 0) do atributo: "+tipo);
        int valor = sc.nextInt();
        if (valor<0){
            return pegarValor(tipo);
        }
        return valor;
    }
}
