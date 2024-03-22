import java.util.ArrayList;

public class Maquina {

	private int idMaquina;
	private String tipoMaquina;
	private String status = "Em Processo";
	private double tempoAtividade;
	@SuppressWarnings("unused")
	private double tempoTotal;
	private double taxaProdutividade;

	// Lista de operadores
	private ArrayList<Operador> operadores;

	public Maquina() {
		this.operadores = new ArrayList<>();
	}

	public void addOperador(Operador operador) {
		operadores.add(operador);
	}

	public int getIdMaquina() {
		return idMaquina;
	}

	public void setIdMaquina(int idMaquina) {
		if (idMaquina != 0)
			this.idMaquina = idMaquina;
		else
			System.out.println("ID inválido!");
	}

	public String getTipoMaquina() {
		return tipoMaquina;
	}

	public void setTipoMaquina(String tipoMaquina) {
		if (tipoMaquina.length() > 5)
			this.tipoMaquina = tipoMaquina;
		else
			System.out.println("Tipo inválido!");
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		if (status.equals("Em Processo") || status.equals("Parada") || status.equals("Em Manutencao")
				|| status.equals("em processo") || status.equals("parada") || status.equals("em manutencao")
				|| status.equals("EM PROCESSO") || status.equals("PARADA") || status.equals("EM MANUTENCAO"))
			this.status = status;
		else
			System.out.println("Status inválido!");
	}

	public double getTempoAtividade() {
		return tempoAtividade;
	}

	public void setTempoAtividade(double tempoAtividade) {
		if (tempoAtividade >= 0)
			this.tempoAtividade = tempoAtividade;
		else
			System.out.println("Tempo de Atividade inválido!");
	}

	public double getTaxaProdutividade() {
		return taxaProdutividade;
	}

	public void setTaxaProdutividade(double tempoAtividade) {
		if (tempoAtividade >= 0)
			this.taxaProdutividade = (tempoAtividade / 20) * 100;
	}

	public String definirTaxaProdutividade(double taxaProdutividade) {
		if (taxaProdutividade >= 75 && taxaProdutividade <= 100) {
			return "A taxa de produtividade da máquina " + idMaquina + " é ótima.";
		} else if (taxaProdutividade >= 50 && taxaProdutividade < 75) {
			return "A taxa de produtividade da máquina " + idMaquina + " é boa.";
		} else if (taxaProdutividade >= 25 && taxaProdutividade < 50) {
			return "A taxa de produtividade da máquina " + idMaquina + " é ruim. Sugiro uma revisão na máquina!";
		} else if (taxaProdutividade >= 0 && taxaProdutividade < 25) {
			return "A taxa de produtividade da máquina " + idMaquina + " é péssima. Sugiro uma revisão na máquina!";
		} else {
			return "Valor inválido para taxa de produtividade.";
		}
	}

}