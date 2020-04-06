// João Guilherme Martins Jatobá
// 18.01790-8

import java.util.Random;

public class Transacao {

    // Este eh o metodo principal da classe, onde acontece o pagamento e a validacao de se ver se ha dinheiro suficiente
    public void Pagamento(String requerimento, Conta paga, Conta recebe){
        double pedido;
        String[] dados = requerimento.split(";");
        // funcao para transformar string para double pesquisada em:
        // https://www.java67.com/2015/06/how-to-convert-string-to-double-java-example.html
        pedido = Double.parseDouble(dados[2]);

        if (paga.getSaldo()< pedido){
            // se quem paga nao consegue pagar, nada acontece. A conta recebedora nao muda de saldo.
            System.out.println(paga.getNome() + " nao tem dinheiro suficiente para pagar.");
            paga.saldo = paga.getSaldo();
        }
        else{
            // caso contrario, se tira o requerimento do saldo do pagador, e coloca no do recebedor
            System.out.println(paga.getNome() + " transferiu " + pedido+ " para " + recebe.getNome());
            recebe.saldo += pedido;
            paga.saldo-= pedido;
        }        

    }

    // Metodo de pegar numero qualquer entre um min e um max


    public int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max-min)+1)+min;
    }


    // metodo criarQRCode eh o metodo de fazer requerimento
    public String criarQRCode( Conta conta, double pedido){
        // pesquisa de formatacao de string
        // https://dzone.com/articles/java-string-format-examples
        
        return String.format("%d;%s;%f;%d",conta.getID(),conta.getNome(),pedido,getRandomNumberInRange(1000, 9999));
        
    }

}