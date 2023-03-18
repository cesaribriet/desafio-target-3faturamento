package utilidade;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import entidades.Fatura;
import entidades.LeitorJSON;

public class LeitorJSONSimple implements LeitorJSON {

	//Faz a leitura do arquivo JSON
	@Override
	public JSONArray leitorArquivoJSON(String caminho) {

		JSONArray array = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(caminho)) ;
			JSONParser parser = new JSONParser();
			array = (JSONArray) parser.parse(reader);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return array;
	}

	//Cria uma lista de Faturas usando dados lidos de um arquivo JSON
	@Override
	public List<Fatura> geradorListaFaturas(JSONArray array) {

		List<Fatura> list = new ArrayList<>();
		for (Object obj : array) {

			JSONObject jobj = (JSONObject) obj;
			long diaLong = (long) jobj.get("dia");
			int dia = (int) diaLong;
			double valor = (double) jobj.get("valor");
			Fatura fat = new Fatura(dia, valor);
			list.add(fat);
		}
		return list;
	}

}
