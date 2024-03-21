import java.util.ArrayList;

public class Produto {

	private int idProduto;
	private String nome;
	private String descricao;
	private String processoFabricacao;
	private double preco;
	private int qtddProdutos;

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		if (idProduto > 0)
			this.idProduto = idProduto;
		else
			System.out.println("ID Produto inválido!");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome.length() >= 3)
			this.nome = nome;
		else
			System.out.println("Nome Produto inválido!");
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	// Lista de componentes
	private ArrayList<Componentes> componentes;

	public Produto() {
		this.componentes = new ArrayList<>();
	}

	public void addComponentes(Componentes componente) {
		componentes.add(componente);
	}

	public String getProcessoFabricacao() {
		return processoFabricacao;
	}

	public void setProcessoFabricacao(String processoFabricacao) {
		this.processoFabricacao = processoFabricacao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		if (preco > 0)
			this.preco = preco;
	}

	public int getQtddProdutos() {
		return qtddProdutos;
	}

	public void setQtddProdutos(int qtddProdutos) {
		this.qtddProdutos = qtddProdutos;
	}

}