// João Guilherme Martins Jatobá
// 18.01790-8

import java.util.Random;

public class Transacao {

    
    public void Pagamento(String requerimento, Conta paga, Conta recebe){
        double pedido;
        String[] dados = requerimento.split(";");
        pedido = Double.parseDouble(dados[2]);
        if (paga.getSaldo()< pedido){
            System.out.println(paga.getNome() + " nao tem dinheiro suficiente para pagar.");
            paga.saldo = paga.getSaldo();
        }
        else{
            System.out.println(paga.getNome() + " transferiu " + pedido+ " para " + recebe.getNome());
            recebe.saldo += pedido;
            paga.saldo-= pedido;
        }        

    }

    public int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max-min)+1)+min;
    }


    // metodo criarQRCode eh o metodo de fazer requerimento
    public String criarQRCode( Conta conta, double pedido){
        return String.format("%d;%s;%f;%d",conta.getID(),conta.getNome(),pedido,getRandomNumberInRange(1000, 9999));
        
    }

}