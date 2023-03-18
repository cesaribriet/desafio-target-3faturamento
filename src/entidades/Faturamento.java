package entidades;

import java.util.ArrayList;
import java.util.List;

public class Faturamento {

	private List<Fatura> faturas = new ArrayList<>();

	public Faturamento(List<Fatura> faturas) {
		this.faturas = faturas;
	}

	public List<Fatura> getFaturas() {
		return faturas;
	}

	// Calcula o menor valor de faturamento do mes
	public double menorValorMes() {
		int diaAtual = 0;
		double menorValor = 0.0;
		boolean flag = false;
		for (Fatura f : faturas) {
			if (flag == false) {
				menorValor = f.getValor();
				flag = true;
			}
			if (f.getValor() != 0.0) {
				if (menorValor > f.getValor()) {
					diaAtual = f.getDia();
					menorValor = f.getValor();
				}
			}
		}
		return menorValor;
	}

	// Calcula o maior valor de faturamento do mes
	public double maiorValorMes() {
		int diaAtual = 0;
		double maiorValor = 0.0;
		boolean flag = false;
		for (Fatura f : faturas) {
			if (flag == false) {
				maiorValor = f.getValor();
				flag = true;
			}
			if (f.getValor() != 0.0) {
				if (maiorValor < f.getValor()) {
					diaAtual = f.getDia();
					maiorValor = f.getValor();
				}
			}
		}
		return maiorValor;
	}

	//Calcula a media do faturamento do mes
	public double mediaMensal() {
		double soma = 0.0;
		int contador = 0;
		for (Fatura f : faturas) {
			if (f.getValor() != 0.0) {
				soma += f.getValor();
				contador++;
			}
		}
		return soma / contador;
	}
}
