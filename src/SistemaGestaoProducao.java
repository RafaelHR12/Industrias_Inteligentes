import java.util.HashMap;
import java.util.Map;

	public class SistemaGestaoProducao {
	    // Dados de exemplo para simular usuários autorizados
	    private static final Map<String, String> usuariosAutorizados = new HashMap<>();

	    static {
	        // Simulando dados de usuários autorizados (usuário, senha)
	        usuariosAutorizados.put("usuario1", "senha1");
	        usuariosAutorizados.put("usuario2", "senha2");
	        // Adicione mais usuários conforme necessário
	    }

	    private boolean usuarioAutenticado;
	    private String usuarioAtual;

	    public SistemaGestaoProducao() {
	        usuarioAutenticado = false;
	        usuarioAtual = "";
	    }

	    public boolean autenticarUsuario(String usuario, String senha) {
	        // Verifica se o usuário e senha correspondem aos dados autorizados
	        if (usuariosAutorizados.containsKey(usuario) && usuariosAutorizados.get(usuario).equals(senha)) {
	            usuarioAutenticado = true;
	            usuarioAtual = usuario;
	            System.out.println("Usuário autenticado com sucesso.");
	            return true;
	        } else {
	            System.out.println("Falha na autenticação. Usuário ou senha incorretos.");
	            return false;
	        }
	    }

	    public void realizarLogout() {
	        if (usuarioAutenticado) {
	            usuarioAutenticado = false;
	            usuarioAtual = "";
	            System.out.println("Logout realizado com sucesso.");
	        } else {
	            System.out.println("Nenhum usuário autenticado.");
	        }
	    }

	    public void acessarSistema() {
	        if (usuarioAutenticado) {
	            System.out.println("Acesso ao sistema concedido para o usuário: " + usuarioAtual);
	            // Coloque aqui as operações que o usuário autenticado pode realizar
	        } else {
	            System.out.println("Acesso negado. É necessário autenticar-se primeiro.");
	        }
	    }

	    public static void main(String[] args) {
	        SistemaGestaoProducao sistema = new SistemaGestaoProducao();
	        sistema.autenticarUsuario("usuario1", "senha1");
	        sistema.acessarSistema();
	        sistema.realizarLogout();
	    }
	}

