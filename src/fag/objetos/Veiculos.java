package fag.objetos;

public class Veiculos {
	
	public String placa;
	public String modelo;
	public Integer horaDeEntrada;
	public Integer horaDeSaida;
	
	public Veiculos(String placa, String modelo, Integer horaDeEntrada, Integer horaDeSaida) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.horaDeEntrada = horaDeEntrada;
		this.horaDeSaida = horaDeSaida;
	}

	@Override
	public String toString() {
		return "Veiculos [placa=" + placa + ", modelo=" + modelo + ", horaDeEntrada=" + horaDeEntrada + ", horaDeSaida="
				+ horaDeSaida + "]";
	}
	
	
	
}
