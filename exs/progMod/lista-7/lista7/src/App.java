/*
=====================================================
Código desenvolvido por:
 ██████╗  █████╗ ██████╗ ██████╗ ██╗███████╗██╗
██╔════╝ ██╔══██╗██╔══██╗██╔══██╗██║██╔════╝██║
██║  ███╗███████║██████╔╝██████╔╝██║█████╗  ██║
██║   ██║██╔══██║██╔══██╗██╔══██╗██║██╔══╝  ██║
╚██████╔╝██║  ██║██████╔╝██║  ██║██║███████╗███████╗
 ╚═════╝ ╚═╝  ╚═╝╚═════╝ ╚═╝  ╚═╝╚═╝╚══════╝╚══════╝
 =====================================================
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

class Comida {
    public String preco;
    public String nome;

    public Comida(String nome, String preco) {
        this.nome = nome;
        this.preco = preco;
    }

}

public class App {

    public static void main(String[] args) throws JsonException, ParseException {

        // Para fins de Teste, gera o arquivo inicial com dados
        escreverJSONInicial();

        Map<String, Comida> map = fromJSON("dados.json");

        // Printando Objetos do Map
        map.values().stream().map(o -> o.toString()).forEach(System.out::println);

        toJSON(map, "json-de-comidas.json");
    }

    public static Map<String, Comida> fromJSON(String nomeArquivo) throws JsonException, ParseException {

        Map<String, Comida> comidasHash = new HashMap<String, Comida>();
        try (FileReader reader = new FileReader(nomeArquivo)) {
            // Read JSON file
            Object obj = Jsoner.deserialize(reader);

            JsonArray listaComidas = (JsonArray) obj;

            listaComidas.forEach(com -> {
                JsonObject comObj = (JsonObject) com;
                Comida comida = new Comida((String) comObj.get("nome"), (String) comObj.get("preco"));
                comidasHash.put(comida.nome, comida);
            });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return comidasHash;
    }

    public static void toJSON(Map<String, Comida> comidas, String nomeArquivo) {
        JsonArray array = new JsonArray();
        for (Comida comida : comidas.values()) {
            JsonObject obj = new JsonObject();
            obj.put("nome", comida.nome);
            obj.put("preco", comida.preco);
            array.add(obj);
        }
        try {
            FileWriter file = new FileWriter(nomeArquivo);
            file.write(array.toJson());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void escreverJSONInicial() {
        String[] nomesComidas = { "Pizza", "Hamburger", "Bolo" };
        String[] precosComidas = { "25", "15", "12" };

        List<Comida> comidas = new ArrayList<Comida>();
        for (int i = 0; i < nomesComidas.length; i++) {
            comidas.add(new Comida(nomesComidas[i], precosComidas[i]));
        }
        JsonArray array = new JsonArray();
        for (Comida comida : comidas) {
            JsonObject obj = new JsonObject();
            obj.put("nome", comida.nome);
            obj.put("preco", comida.preco);
            array.add(obj);
        }
        try {
            FileWriter file = new FileWriter("dados.json");
            file.write(array.toJson());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
