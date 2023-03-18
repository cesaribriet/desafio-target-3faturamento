package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Fatura;
import entidades.Faturamento;
import entidades.LeitorJSON;
import utilidade.LeitorJSONSimple;

public class Programa {

	public static void main(String[] args) {
		
		
		System.out.println("Digite o caminho do arquivo JSON (Ex: C:/Temp/dados.json): ");
		Scanner sc = new Scanner(System.in);
		
		//Como exemplo, considerei o caminho C:/Temp/dados.json
		String caminho = sc.nextLine();
		LeitorJSON leitor = new LeitorJSONSimple();
		
		List<Fatura> fatList = new ArrayList<>();
		fatList =leitor.geradorListaFaturas(leitor.leitorArquivoJSON(caminho));
		Faturamento fat = new Faturamento(fatList);
		
		System.out.println("O menor valor de faturamento ocorrido no mês foi: " + fat.menorValorMes());
		System.out.println("O maior valor de faturamento ocorrido no mês foi: " + fat.maiorValorMes());
		System.out.println("O valor do faturamento medio no mês foi: " + fat.mediaMensal());
		
		sc.close();
		}
	}

