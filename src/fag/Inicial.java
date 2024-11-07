package fag;

import java.util.Scanner;

import fag.objetos.Vagas;
import fag.objetos.Veiculos;

public class Inicial {
	
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		Boolean menu = true;

		while(menu) {
			System.out.println("Selecione uma das alternativas: \n"
					+ "1 - cadastro de vagas \n"
					+ "2 - Cadastro de veículos \n"
					+ "3 - retirar veículo da vaga \n"
					+ "4 - Relatório de vagas \n"
					+ "5 - histórico de permanência \n"
					+ "6 - sair");

			int escolha = scanner.nextInt();

			switch (escolha) {
				case 1:
					Vagas.adicionarVagas();  
					break;
				case 2:
					Veiculos.adicionarCarro();  
					break;
				case 3:
					retirarVeiculo();  
					break;
				case 4:
					relatorioVagas();  
					break;
				case 5:
					exibirHistoricoPermanencia();
					break;
				case 6:
					menu = false;  
					System.out.println("adeus :D");
					break;
				default:
					System.out.println("opção inválida. tente novamente.");
					break;
			}
		}
	}


	public static void retirarVeiculo() {
		System.out.println("\nselecione o número da vaga para retirar o veículo:");


		boolean vagasOcupadas = false;
		for (Vagas vaga : Vagas.listaVagas) {
			if (vaga.disponibilidade) {
				vagasOcupadas = true;
				System.out.println("vaga " + vaga.numeroVagas + " (tamanho: " + vaga.tamanhoDaVaga + ")");
			}
		}

		if (!vagasOcupadas) {
			System.out.println("não há vagas ocupadas no momento.");

		}

		System.out.println("digite o número da vaga para retirar o veículo:");
		int numeroVaga = scanner.nextInt();

		boolean vagaEncontrada = false;
		for (Vagas vaga : Vagas.listaVagas) {
			if (vaga.numeroVagas == numeroVaga && vaga.disponibilidade) {
				vaga.disponibilidade = false;  
				System.out.println("veículo retirado da vaga " + numeroVaga + ".");
				vagaEncontrada = true;

			}
		}

		if (!vagaEncontrada) {
			System.out.println("vaga não encontrada ou já está livre.");
		}
	}

	public static void relatorioVagas() {
		System.out.println("\nrelatório de vagas:\n");

		if (Vagas.listaVagas.isEmpty()) {
			System.out.println("não há vagas cadastradas.");

		}

		for (Vagas vaga : Vagas.listaVagas) {
			String status = vaga.disponibilidade ? "ocupada" : "livre";
			System.out.println("vaga " + vaga.numeroVagas + " (" + vaga.tamanhoDaVaga + "): " + status);
		}
	}
	
	public static void exibirHistoricoPermanencia() {
	    System.out.println("\nhistórico de permanência:\n");

	    if (Veiculos.listaVeiculos.isEmpty()) {
	        System.out.println("não há veículos no histórico.");

	    }
	    //gambiarra do krl
	    for (Veiculos veiculo : Veiculos.listaVeiculos) {
	        int horaEntrada =  veiculo.horaDeEntrada;
	        int minutoEntrada =  veiculo.minutoEntrada;
	        int horaSaida =  veiculo.horaDeSaida;
	        int minutoSaida =  veiculo.minutoSaida;
	        
	        //queria que a formatação das horas ficassem melhor, e vi que tinha esse "string format", fiquei com preguiça de fazer manual :3
	        String horarioEntrada = String.format("%02d:%02d", horaEntrada, minutoEntrada);
	        String horarioSaida = String.format("%02d:%02d", horaSaida, minutoSaida);

	        System.out.println("placa: " + veiculo.placa);
	        System.out.println("modelo: " + veiculo.modelo);
	        System.out.println("entrada: " + horarioEntrada);
	        System.out.println("saída: " + horarioSaida);
	        System.out.println("valor pago: R$ " + veiculo.pagamento);
	    }
	}
}
