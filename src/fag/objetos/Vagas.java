package fag.objetos;

public class Vagas {
	
	public Integer numeroVagas;
	public String tamanhoDaVaga;
	public Boolean disponibilidade;
	
	public Vagas(Integer numeroVagas, String tamanhoDaVaga, Boolean disponibilidade) {
		super();
		this.numeroVagas = numeroVagas;
		this.tamanhoDaVaga = tamanhoDaVaga;
		this.disponibilidade = disponibilidade;
	}

	@Override
	public String toString() {
		return "Vagas [numeroVagas=" + numeroVagas + ", tamanhoDaVaga=" + tamanhoDaVaga + ", disponibilidade="
				+ disponibilidade + "]";
	}
	
	
}
