package sample.model;

import java.util.ArrayList;
import java.util.List;

public class ListaCartas {
    public List<Carta> listaCartas;

    public ListaCartas() {
        listaCartas = new ArrayList<>();
    }

    public int getNumAtual(String idAtual){
        for (int i=0;i<this.listaCartas.size();i++){
            if(idAtual.equals(this.listaCartas.get(i).getIdCarta())){
                return i;
            }
        }
        return -1;
    }

    public boolean idExistente(String novoID){
        for (Carta carta:
             this.listaCartas) {
            if(carta.getIdCarta().equals(novoID)){
                return true;}
        }
        return false;
    }


}
