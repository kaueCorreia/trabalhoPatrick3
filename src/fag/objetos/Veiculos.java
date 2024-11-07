package fag.objetos;

import java.util.ArrayList;
import java.util.List;

import fag.Inicial;

public class Veiculos {
	
	public static List<Veiculos> listaVeiculos = new ArrayList<Veiculos>();
	
	//n queria criar esses atributos de minutos para entrada e saida, mas não achei outra forma mais prática para calcular.
	public String placa;
	public String modelo;
	public String tamanho;
	public int horaDeEntrada;
	public int horaDeSaida;
	public int minutoEntrada;
	public int minutoSaida;
	public Double pagamento;
	
	public Veiculos(String placa, String modelo, String tamanho, int horaDeEntrada, int horaDeSaida, int minutoEntrada, int minutoSaida,  Double pagamento) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.tamanho = tamanho;
		this.horaDeEntrada = horaDeEntrada;
		this.horaDeSaida = horaDeSaida;
		this.pagamento = pagamento;
	}

	
	
	@Override
	public String toString() {
		return "Veiculos [placa=" + placa + ", modelo=" + modelo + ", tamanho=" + tamanho + ", horaDeEntrada="
				+ horaDeEntrada + ", horaDeSaida=" + horaDeSaida + "]";
	}



	public static void adicionarCarro() {
	    System.out.println("digite a placa do carro: \n");
	    String placa = Inicial.scanner.next();

	    System.out.println("digite o modelo do carro: \n");
	    String modelo = Inicial.scanner.next();

	    Boolean menu3 = true;
	    String tamanho = null;

	    while (menu3) {
	        System.out.println("selecione o número do tamanho do carro: \n"
	                + "1 - pequeno\n"
	                + "2 - médio\n"
	                + "3 - grande\n");

	        int escolher = Inicial.scanner.nextInt();

	        if (escolher == 1) {
	            tamanho = "pequeno";
	            menu3 = false;
	        } else if (escolher == 2) {
	            tamanho = "médio";
	            menu3 = false;
	        } else if (escolher == 3) {
	            tamanho = "grande";
	            menu3 = false;
	        } else {
	            System.out.println("número inválido \n");
	        }
	    }

	    System.out.println("digite a hora de entrada (0-23):");
	    int horaDeEntrada = Inicial.scanner.nextInt();
	    System.out.println("digite os minutos de entrada (0-59):");
	    int minutoEntrada = Inicial.scanner.nextInt();

	    System.out.println("digite a hora de saída (0-23):");
	    int horaDeSaida = Inicial.scanner.nextInt();
	    System.out.println("digite os minutos de saída (0-59):");
	    int minutoSaida = Inicial.scanner.nextInt();

	    int totalMinutosEntrada = (horaDeEntrada * 60) + minutoEntrada;
	    int totalMinutosSaida = (horaDeSaida * 60) + minutoSaida;

	    int tempoPermanenciaMinutos = totalMinutosSaida - totalMinutosEntrada;

	    int horasPermanencia = tempoPermanenciaMinutos / 60;
	    int minutosPermanencia = tempoPermanenciaMinutos % 60;

	    double valorPagar;
	    if (horasPermanencia < 1 || (horasPermanencia == 1 && minutosPermanencia == 0)) {
	        valorPagar = 5.00;
	    } else if (horasPermanencia < 3 || (horasPermanencia == 3 && minutosPermanencia == 0)) {
	        valorPagar = 10.00;
	    } else {
	        valorPagar = 15.00;
	    }
	    
	    Vagas vagaDisponivel = null;
	    for (Vagas vaga : Vagas.listaVagas) {
	        if (!vaga.disponibilidade && vaga.tamanhoDaVaga.equals(tamanho)) {
	            vagaDisponivel = vaga;

	            vaga.veiculoAssociado = new Veiculos(placa, modelo, tamanho, horaDeEntrada, horaDeSaida, minutoEntrada, minutoSaida, valorPagar);
	            vaga.disponibilidade = true;  
	        }
	    }

	    if (vagaDisponivel != null) {
	    	//vai adicionar na lista apenas se tiver vaga sobrando
	        System.out.println("Veículo estacionado na vaga número: " + vagaDisponivel.numeroVagas);
		    System.out.println("Valor a pagar: R$ " + valorPagar);
	        System.out.println("tempo de permanência: " + horasPermanencia + " horas e " + minutosPermanencia + " minutos.");
	        
	        Veiculos veiculo = new Veiculos(placa, modelo, tamanho, horaDeEntrada, horaDeSaida, minutoEntrada, minutoSaida, valorPagar);
		    Veiculos.listaVeiculos.add(veiculo);
	    } else {
	        System.out.println("não há vagas disponíveis para o tamanho do veículo.");
	    }
	}
}


