package sample.model;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList e metodos criados para guardar e manipular objetos Carta
 * @author Andre Lebrao 18.00356-7
 * @author Joao Guilherme Jatobá 18.01790-8
 * @since 15/09/2020
 * @see Carta
 */
public class ListaCartas {
    public List<Carta> listaCartas;

    public ListaCartas() {
        listaCartas = new ArrayList<>();
    }

    /**
     * Caso nao encontre o ID na lista, retorna -1
     * @param idAtual ID unico da carta procurada
     * @return indice da posicao da carta na lista<br>
     *
     */
    public int getNumAtual(String idAtual){
        for (int i=0;i<this.listaCartas.size();i++){
            if(idAtual.equals(this.listaCartas.get(i).getIdCarta())){
                return i;
            }
        }
        return -1;
    }

    /**
     * @param novoID ID unico da carta para ser checado
     * @return True, caso ja exista uma carta com o ID fornecido e false no caso contrario
     */
    public boolean idExistente(String novoID){
        for (Carta carta:
             this.listaCartas) {
            if(carta.getIdCarta().equals(novoID)){
                return true;}
        }
        return false;
    }


}
