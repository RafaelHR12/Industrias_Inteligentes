public class Componentes {

	private int idComponente;
	private String nomeComponente;
	private int qtddComponente;

	public int getIdComponente() {
		return idComponente;
	}

	public void setIdComponente(int idComponente) {
		if (idComponente > 0)
			this.idComponente = idComponente;
	}

	public String getNomeComponente() {
		return nomeComponente;
	}

	public void setNomeComponente(String nomeComponente) {
		this.nomeComponente = nomeComponente;
	}

	public int getQtddComponente() {
		return qtddComponente;
	}

	public void setQtddComponente(int qtddComponente) {
		if (qtddComponente >= 0)
			this.qtddComponente = qtddComponente;
	}

}