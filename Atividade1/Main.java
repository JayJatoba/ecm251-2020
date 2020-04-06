import java.util.Scanner;

// João Guilherme Martins Jatobá
// 18.01790-8

public class Main {
    public static void main(String[] args) {
        String requerimento;
        Scanner sc = new Scanner(System.in);
        // no momento nao ha confirmacao de senha ou email
        String nome, senha = "";
        String email = "";
        // criacao usuarios e contas
        Usuario u1, u2, u3;
        Conta c1, c2, c3;
        System.out.println("Nome usuario 1: ");
        nome = sc.nextLine();
        u1 = new Usuario(nome,senha,email);
        c1 = new Conta(u1, 1000);
        System.out.println("Nome usuario 2: ");
        nome = sc.nextLine();
        u2 = new Usuario(nome,senha,email);
        c2 = new Conta(u2, 250);
        System.out.println("Nome usuario 3: ");
        nome = sc.nextLine();
        u3 = new Usuario(nome,senha,email);
        c3 = new Conta(u3, 3000);

        // As contas tem saldos iniciais dados pelo enunciado
        
        // Estado inicial
        System.out.println("Estado Inicial: ");
        System.out.println("Nome Usuario: " + c1.getNome() + " - Saldo: " + c1.getSaldo());
        System.out.println("Nome Usuario: " + c2.getNome() + " - Saldo: " + c2.getSaldo());
        System.out.println("Nome Usuario: " + c3.getNome() + " - Saldo: " + c3.getSaldo());


        // Para o exercicio, serao feitas:
        // Um pedido de recebimento de 1,
        // 2 e 3 pagam o requerimento
        // 2 paga d novo e faz requerimento
        // 3 paga 2
        Transacao transacao = new Transacao();
        requerimento = transacao.criarQRCode(c1, 250);
        transacao.Pagamento(requerimento, c2, c1);
        transacao.Pagamento(requerimento, c3, c1);
        transacao.Pagamento(requerimento, c2, c1);
        requerimento = transacao.criarQRCode(c2, 1000);
        transacao.Pagamento(requerimento, c3, c2);


        // Estado final
        System.out.println("\n\n\n\nEstado Final: ");
        System.out.println("Nome Usuario: " + c1.getNome() + " - Saldo: " + c1.getSaldo());
        System.out.println("Nome Usuario: " + c2.getNome() + " - Saldo: " + c2.getSaldo());
        System.out.println("Nome Usuario: " + c3.getNome() + " - Saldo: " + c3.getSaldo());

        sc.close();
    }
}