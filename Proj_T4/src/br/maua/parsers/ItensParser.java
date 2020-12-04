package br.maua.parsers;
import br.maua.model.Item;
import org.json.JSONObject;
/**
 * Responsavel pela transformacao do objeto json em um objeto do tipo Item vice e versa
 * @author Andre Lebrao 18.00356-7
 * @author Joao Guilherme Jatoba 18.01790-8
 * @since 24/11/2020
 */
public class ItensParser {

    public static JSONObject toJSON(Item item){
        JSONObject json = new JSONObject();
        json.put("nome",item.getNome());
        json.put("preco",item.getPreco());
        json.put("peso",item.getPeso());
        json.put("quant",item.getQuant());
        return json;
    }
    /**
     * Transforma um objeto json em um objeto Item
     * @param json Objeto json que tem os dados de um item
     * @return Objeto do tipo item
     */
    public static Item fromJSON(JSONObject json){
        return new Item(json.getString("nome"),json.getFloat("preco"),json.getFloat("peso"),json.getInt("quant"));
    }
}
