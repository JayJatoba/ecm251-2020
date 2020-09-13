package sample.model;

import java.util.ArrayList;
import java.util.List;

public class ListaCartas {
    public List<Carta> lista_carta;

    public ListaCartas() {
        lista_carta = new ArrayList<>();
    }

    public void adicionarCarta(String urlImagem, int id, int colecao, String nome, String raridade, String serie){
        lista_carta.add(new Carta(urlImagem,id,colecao,nome,raridade,serie));
    }



}
