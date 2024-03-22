import java.util.ArrayList;
import java.util.Scanner;

public class LinhaProducao {

	@SuppressWarnings("unused")
	private int Linha;
	private String statusLinha;
	private double tempoCiclo;

	// Lista de máquinas
	private ArrayList<Maquina> maquinas;
	@SuppressWarnings("unused")
	private int idLinha;

	public LinhaProducao() {
		this.maquinas = new ArrayList<>();
	}

	public void addMaquina(Maquina maquina) {
		maquinas.add(maquina);
	}

	public int getIdLinha() {
		return getIdLinha();
	}

	public void setIdLinha(int idLinha) {
		if (idLinha > 5)
			this.idLinha = idLinha;
	}

	public String getStatusLinha() {
		return statusLinha;
	}

	public void setStatusLinha(String statusLinha) {
		this.statusLinha = "Inativa";
	}

	public double getTempoCiclo() {
		return tempoCiclo;
	}

	public void setTempoCiclo(double tempoCiclo) {
		if (tempoCiclo >= 0)
			this.tempoCiclo = tempoCiclo;
	}

	Maquina maquina = new Maquina();

	public void exibirMaquinas() {
		System.out.println("Máquinas na linha de produção:");
		for (Maquina maquina : maquinas) {
			System.out.println("ID: " + maquina.getIdMaquina() + " - Tipo: " + maquina.getTipoMaquina());
		}
	}

	private boolean producaoIniciada;

	public void GerenciarProducao() {
		this.producaoIniciada = false;
	}

	public boolean isProducaoIniciada() {
		return producaoIniciada;
	}

	public void setProducaoIniciada(boolean producaoIniciada) {
		this.producaoIniciada = producaoIniciada;
	}

	public void iniciarProducao() {
		setProducaoIniciada(true);
		System.out.println("Produção iniciada!");
	}

	public void pararProducao() {
		setProducaoIniciada(false);
		System.out.println("Produção parada!");
	}

	public void congelarProducao() {
		System.out.println("Produção congelada!");
	}

	public void menuInteracao() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Menu de interação:");
		System.out.println("1. Iniciar produção");
		System.out.println("2. Parar produção");
		System.out.println("3. Congelar produção");
		System.out.print("Digite 1, 2 ou 3 para escolher a ação: ");
		int opcao = scanner.nextInt();

		switch (opcao) {
		case 1:
			iniciarProducao();
			break;
		case 2:
			pararProducao();
			break;
		case 3:
			congelarProducao();
			break;
		default:
			System.out.println("Opção inválida!");
		}

		scanner.close();
	}

}