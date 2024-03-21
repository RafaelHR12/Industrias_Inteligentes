import java.util.ArrayList;

public class Operador {
    private int idFuncionario;
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private ArrayList<Maquina> maquinasOperadas;

    public Operador(int idFuncionario, String nome, String email, String telefone, String senha) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.maquinasOperadas = new ArrayList<>();
    }

    public Operador(Class<Integer> class1, String nome2, String email2, String senha2, String telefone2) {
		// TODO Auto-generated constructor stub
	}

	public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public boolean setNome(String nome) {
    	if (nome != null && nome.length() >= 3 && nome.matches(".[a-zA-Z].") && !nome.matches("//d")) {
    		this.nome = nome;
    		return true;
    	}
    	return false;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ArrayList<Maquina> getMaquinasOperadas() {
        return maquinasOperadas;
    }

    public void adicionarMaquinaOperada(Maquina maquina) {
        this.maquinasOperadas.add(maquina);
    }

    public void removerMaquinaOperada(Maquina maquina) {
        this.maquinasOperadas.remove(maquina);
    }
}