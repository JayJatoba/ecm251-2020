// João Guilherme Martins Jatobá
// 18.01790-8

public class Conta {
    private Usuario user;
    private static int totConta=1;
    private int idConta;
    public double saldo;

    public Conta(Usuario user, double saldo){
        this.user = user;
        this.saldo = saldo;
        this.idConta = totConta;
        totConta+=1;
    }

    public double getSaldo(){
        return saldo;
    }

    public int getID(){
        return idConta;
    }

    public String getNome(){
        return user.nome;
    }

    
    
}