package sample.model;

import java.util.ArrayList;
import java.util.List;

public class ListaCartas {
    public List<Carta> listaCartas;

    public ListaCartas() {
        listaCartas = new ArrayList<>();
    }

    public void adicionarCarta(String urlImagem, String idCarta,String colecao, String nome, String raridade, String serie){
        listaCartas.add(new Carta(urlImagem,idCarta,colecao,nome,raridade,serie));
    }

    public int getNumAtual(String idAtual){
        for (int i=0;i<this.listaCartas.size();i++){
            if(idAtual.equals(this.listaCartas.get(i).getIdCarta())){
                return i;
            }
        }
        return -1;
    }


}
