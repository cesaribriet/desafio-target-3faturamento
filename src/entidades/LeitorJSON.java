package entidades;

import java.util.List;

import org.json.simple.JSONArray;

public interface LeitorJSON {

	public JSONArray leitorArquivoJSON(String caminho);
	public List<Fatura> geradorListaFaturas(JSONArray array);
	
}
