import java.util.Scanner;

public class SistemaLogin {
    // Outros atributos e métodos da classe

    // Método para cadastrar funcionário
    public static Operador cadastrarFuncionario() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Insira o nome do funcionário: ");
        String nome = sc.nextLine();

        System.out.print("Insira o e-mail do funcionário: ");
        String email = sc.nextLine();

        // Verifica se o e-mail é válido
        while (!verificaEmail(email)) {
            System.out.println("E-mail inválido. Insira novamente:");
            email = sc.nextLine();
        }

        System.out.print("Insira a senha do funcionário: ");
        String senha = sc.nextLine();

        // Verifica se a senha atende aos critérios
        while (!verificaSenha(senha)) {
            System.out.println("Senha inválida. A senha deve ter pelo menos 6 caracteres, conter letras maiúsculas, "
                    + "letras minúsculas e números. Insira novamente:");
            senha = sc.nextLine();
        }

        System.out.print("Insira o telefone do funcionário: ");
        String telefone = sc.nextLine();

        // Retorna um novo objeto Funcionario com os dados inseridos
        return new Operador(0, nome, email, senha, telefone);
    }

	private static boolean verificaSenha(String senha) {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean verificaEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	public static SistemaLogin realizarLogin(Scanner sc) {
		// TODO Auto-generated method stub
		return null;
	}

    // Métodos verificaEmail e verificaSenha continuam iguais

    // Outros métodos da classe
}