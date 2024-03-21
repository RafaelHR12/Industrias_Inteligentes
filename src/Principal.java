import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinhaProducao lpr = new LinhaProducao();
        
		System.out.println("\n=== MENU DE INTERAÇÃO ===");
		System.out.println("1 - Gerenciar Produção");
		System.out.println("2 - Gerenciar Empresa");
		System.out.println("3 - Logout");
		System.out.println("0 - Encerrar Programa");

		int opcao = -1;
		while (opcao != 0) {
			System.out.print("Escolha uma opção: ");
			opcao = sc.nextInt();
			sc.nextLine(); // Limpar o buffer

			switch (opcao) {
			case 1:
				System.out.println("Opção 1 selecionada\n");
				System.out.println("===Gerenciar Produção===\n");
			
				lpr.menuInteracao();
				opcao = 0;
				break;
			case 2:
				System.out.println("Opção 2 selecionada\n");
				System.out.println("===Gerenciar Empresa===\n");
				
				System.out.println("---Operador---");
				int qtddOperador = solicitarQuantidade("Operadores", sc);
				int[] idOperadores = new int[qtddOperador];
				String[] nomesOperadores = new String[qtddOperador];
				criarOperadores(qtddOperador, idOperadores, nomesOperadores, sc);
				System.out.println("----------------"); // linha em branco para separar os operadores
				
				System.out.println("---Máquinas---");
				int qtddMaquina = solicitarQuantidade("Máquinas", sc);
				int[] idMaquinas = new int[qtddMaquina];
				String[] tiposMaquinas = new String[qtddMaquina];
				String[] statusMaquinas = new String[qtddMaquina];
				double[] temposAtividade = new double[qtddMaquina];
				criarMaquinas(qtddMaquina, idMaquinas, tiposMaquinas, statusMaquinas, temposAtividade, sc);
				System.out.println("--------------"); // linha em branco para separar as máquinas
				
				System.out.println("---Componentes---");
				int qtddComponente = solicitarQuantidade("Componentes", sc);
				int[] idComponentes = new int[qtddComponente];
				String[] nomesComponentes = new String[qtddComponente];
				int[] qtddComponentes = new int[qtddComponente];
				criarComponentes(qtddComponente, idComponentes, nomesComponentes, qtddComponentes, sc);
				System.out.println("-----------------"); // linha em branco para separar os componentes
				
				System.out.println("---Linhas de Produção---");
				int qtddLinhas = solicitarQuantidade("Linhas de Produção", sc);
				String[] idLinhas = new String[qtddLinhas];
				String[] statusLinhas = new String[qtddLinhas];
				double[] temposCiclo = new double[qtddLinhas];
				criarLinhasProducao(qtddLinhas, idLinhas, statusLinhas, temposCiclo, sc);
				System.out.println("------------------------"); // linha em branco para separar as linhas de produção
				
				System.out.println("---Pedidos---");
				int qtddPedido = solicitarQuantidade("Pedido", sc);
				int[] idPedido = new int[qtddPedido];
				Date[] dataEntrega = new Date[qtddPedido];
				double[] precoTotal = new double[qtddPedido];
				int[] qtddTotal = new int[qtddPedido];
				criarPedido(qtddPedido, idPedido, dataEntrega, qtddTotal, sc);
				System.out.println("----------------"); // linha em branco para separar os pedidos
				
				System.out.println("---Produtos---");
				int qtddProduto = solicitarQuantidade("Produto", sc);
				int[] idProduto = new int[qtddProduto];
				String[] nomeProduto = new String[qtddProduto];
				String[] descricaoProduto = new String[qtddProduto];
				String[] processoFabricacao = new String[qtddProduto];
				double[] precoProduto = new double[qtddProduto];
				int[] qtddProdutos = new int[qtddProduto];
				System.out.println("----------------"); // linha em branco para separar os produtos
				
				criarProduto(qtddProduto, idProduto, nomeProduto, descricaoProduto, processoFabricacao, precoProduto,
						qtddProdutos, sc);
				
				exibirInformacoes(idOperadores, nomesOperadores, idMaquinas, tiposMaquinas, statusMaquinas, temposAtividade,
						idComponentes, nomesComponentes, qtddComponentes, idLinhas, statusLinhas, temposCiclo, idPedido,
						dataEntrega, precoTotal, qtddTotal, idProduto, nomeProduto, descricaoProduto, processoFabricacao,
						precoProduto, qtddProdutos);
				break;
			case 3:
				System.out.println("Logout realizado com sucesso.");
				return; // Encerra o método exibirMenu e volta para o main
			case 0:
				System.out.println("Encerrando o programa. Até logo!");
				System.exit(0); // Encerra o programa
			default:
				System.out.println("Opção inválida. Digite novamente.");
				break;
			}
		}

	}
	
	public static int solicitarQuantidade(String tipo, Scanner sc) {
		System.out.print("Informe a quantidade de " + tipo + ": ");
		return sc.nextInt();
	}

	public static void criarOperadores(int qtdd, int[] ids, String[] nomes, Scanner sc) {
		sc.nextLine(); // Limpar o buffer
		for (int i = 0; i < qtdd; i++) {
			int id;
			boolean idRepetido;
			do {
				System.out.print("Informe o ID do Operador " + (i + 1) + ": ");
				id = sc.nextInt();
				idRepetido = verificarRepeticao(id, ids);
				if (idRepetido) {
					System.out.println("ID já existe. Por favor, informe um novo ID.");
				}
			} while (idRepetido);
			ids[i] = id;
			sc.nextLine(); // Limpar o buffer
			System.out.print("Informe o NOME do Operador " + (i + 1) + ": ");
			nomes[i] = sc.nextLine();
		}
	}

	public static void criarMaquinas(int qtdd, int[] ids, String[] tipos, String[] status, double[] tempos,
			Scanner sc) {
		sc.nextLine(); // Limpar o buffer
		for (int i = 0; i < qtdd; i++) {
			int id;
			boolean idRepetido;
			do {
				System.out.print("Informe o ID da Máquina " + (i + 1) + ": ");
				id = sc.nextInt();
				idRepetido = verificarRepeticao(id, ids);
				if (idRepetido) {
					System.out.println("ID já existe. Por favor, informe um novo ID.");
				}
			} while (idRepetido);
			ids[i] = id;
			sc.nextLine(); // Limpar o buffer
			System.out.print("Informe o TIPO da Máquina " + (i + 1) + ": ");
			tipos[i] = sc.nextLine();
			System.out.println("Selecione o STATUS da Máquina " + (i + 1) + ":");
			System.out.println("1 - Em processo");
			System.out.println("2 - Em manutenção");
			System.out.println("3 - Desativado");
			int opcao;
			do {
				System.out.print("Opção: ");
				opcao = sc.nextInt();
				switch (opcao) {
				case 1:
					status[i] = "Em processo";
					break;
				case 2:
					status[i] = "Em manutenção";
					break;
				case 3:
					status[i] = "Desativado";
					break;
				default:
					System.out.println("Opção inválida.");
					break;
				}
			} while (opcao < 1 || opcao > 3);
			System.out.print("Informe o TEMPO DE ATIVIDADE da Máquina " + (i + 1) + ": ");
			tempos[i] = sc.nextDouble();
			sc.nextLine(); // Limpar o buffer
		}
	}

	public static void criarComponentes(int qtdd, int[] ids, String[] nomes, int[] qtdds, Scanner sc) {
	    sc.nextLine(); // Limpar o buffer
	    for (int i = 0; i < qtdd; i++) {
	        int id;
	        boolean idRepetido;
	        do {
	            System.out.print("Informe o ID do Componente " + (i + 1) + ": ");
	            id = sc.nextInt();
	            idRepetido = verificarRepeticao(id, ids);
	            if (idRepetido) {
	                System.out.println("ID já existe. Por favor, informe um novo ID.");
	            }
	        } while (idRepetido);
	        ids[i] = id;
	        sc.nextLine(); // Limpar o buffer
	        System.out.print("Informe o NOME do Componente " + (i + 1) + ": ");
	        nomes[i] = sc.nextLine();
	        System.out.print("Informe a QUANTIDADE do Componente " + (i + 1) + ": ");
	        qtdds[i] = sc.nextInt();
	        sc.nextLine(); // Limpar o buffer
	    }
	}

	public static void criarLinhasProducao(int qtdd, String[] ids, String[] status, double[] tempos, Scanner sc) {
	    sc.nextLine(); // Limpar o buffer
	    for (int i = 0; i < qtdd; i++) {
	        String id;
	        boolean idRepetido;
	        do {
	            System.out.print("Informe o ID da Linha de Produção " + (i + 1) + ": ");
	            id = sc.nextLine();
	            idRepetido = verificarRepeticao(id, ids);
	            if (idRepetido) {
	                System.out.println("ID já existe. Por favor, informe um novo ID.");
	            }
	        } while (idRepetido);
	        ids[i] = id;
	        System.out.println("Selecione o STATUS da Linha de Produção " + (i + 1) + ":");
	        System.out.println("1 - Operando");
	        System.out.println("2 - Parado");
	        int opcao;
	        do {
	            System.out.print("Opção: ");
	            opcao = sc.nextInt();
	            switch (opcao) {
	                case 1:
	                    status[i] = "Operando";
	                    break;
	                case 2:
	                    status[i] = "Parado";
	                    break;
	                default:
	                    System.out.println("Opção inválida.");
	                    break;
	            }
	        } while (opcao < 1 || opcao > 2);
	        System.out.print("Informe o TEMPO DE CICLO da Linha de Produção " + (i + 1) + ": ");
	        tempos[i] = sc.nextDouble();
	        sc.nextLine(); // Limpar o buffer
	    }
	}

	public static void criarPedido(int qtdd, int[] ids, Date[] dataEntrega, int[] qtddTotal, Scanner sc) {
	    sc.nextLine(); // Limpar o buffer
	    for (int i = 0; i < qtdd; i++) {
	        System.out.print("Informe o ID do pedido " + (i + 1) + ": ");
	        ids[i] = sc.nextInt();
	        sc.nextLine(); // Limpar o buffer
	        System.out.print("Informe a data de entrega do pedido " + (i + 1) + " (dd/MM/yyyy): ");
	        String dataStr = sc.nextLine();
	        dataEntrega[i] = convertStringToDate(dataStr);
	        System.out.print("Informe a quantidade total do pedido " + (i + 1) + ": ");
	        qtddTotal[i] = sc.nextInt();
	        sc.nextLine(); // Limpar o buffer
	    }
	}

	public static void criarProduto(int qtdd, int[] ids, String[] nome, String[] descricao, String[] processoFabricacao,
	        double[] preco, int[] qtddProdutos, Scanner sc) {
	    sc.nextLine(); // Limpar o buffer
	    for (int i = 0; i < qtdd; i++) {
	        int id;
	        boolean idRepetido;
	        do {
	            System.out.print("Informe o ID do Produto " + (i + 1) + ": ");
	            id = sc.nextInt();
	            idRepetido = verificarRepeticao(id, ids);
	            if (idRepetido) {
	                System.out.println("ID já existe. Por favor, informe um novo ID.");
	            }
	        } while (idRepetido);
	        ids[i] = id;
	        sc.nextLine(); // Limpar o buffer
	        System.out.print("Informe o NOME do Produto " + (i + 1) + ": ");
	        nome[i] = sc.nextLine();
	        System.out.print("Informe a DESCRIÇÃO do Produto " + (i + 1) + ": ");
	        descricao[i] = sc.nextLine();
	        System.out.print("Informe o PROCESSO DE FABRICAÇÃO do Produto " + (i + 1) + ": ");
	        processoFabricacao[i] = sc.nextLine();
	        System.out.print("Informe o PREÇO do Produto " + (i + 1) + ": ");
	        preco[i] = sc.nextDouble();
	        System.out.print("Informe a QUANTIDADE do Produto " + (i + 1) + ": ");
	        qtddProdutos[i] = sc.nextInt();
	        sc.nextLine(); // Limpar o buffer
	    }
	}

	public static boolean verificarRepeticao(int id, int[] ids) {
		for (int i : ids) {
			if (id == i) {
				return true;
			}
		}
		return false;
	}

	public static boolean verificarRepeticao(String id, String[] ids) {
		for (String i : ids) {
			if (id.equals(i)) {
				return true;
			}
		}
		return false;
	}

	public static void exibirInformacoes(int[] idsOperadores, String[] nomesOperadores, int[] idsMaquinas,
			String[] tiposMaquinas, String[] statusMaquinas, double[] temposAtividade, int[] idsComponentes,
			String[] nomesComponentes, int[] qtddsComponentes, String[] idsLinhas, String[] statusLinhas,
			double[] temposCiclo, int[] idPedido, Date[] dataEntrega, double[] precoTotal, int[] qtddTotal,
			int[] idProduto, String[] nomeProduto, String[] descricaoProduto, String[] processoFabricacao,
			double[] precoProduto, int[] qtddProduto) {
		System.out.println("\n---Operadores---");
		for (int i = 0; i < idsOperadores.length; i++) {
			System.out.println("ID: " + idsOperadores[i]);
			System.out.println("Nome: " + nomesOperadores[i]);
			System.out.println("----------------"); // linha em branco para separar os operadores
		}

		System.out.println("---Máquinas---");
		for (int i = 0; i < idsMaquinas.length; i++) {
			System.out.println("ID: " + idsMaquinas[i]);
			System.out.println("Tipo: " + tiposMaquinas[i]);
			System.out.println("Status: " + statusMaquinas[i]);
			System.out.println("Tempo de Atividade: " + temposAtividade[i] + " Horas");
			System.out.println("--------------"); // linha em branco para separar as máquinas
		}

		System.out.println("---Componentes---");
		for (int i = 0; i < idsComponentes.length; i++) {
			System.out.println("ID: " + idsComponentes[i]);
			System.out.println("Nome: " + nomesComponentes[i]);
			System.out.println("Quantidade: " + qtddsComponentes[i]);
			System.out.println("-----------------"); // linha em branco para separar os componentes
		}

		System.out.println("---Linhas de Produção---");
		for (int i = 0; i < idsLinhas.length; i++) {
			System.out.println("ID: " + idsLinhas[i]);
			System.out.println("Status: " + statusLinhas[i]);
			System.out.println("Tempo de Ciclo: " + temposCiclo[i] + " Horas");
			System.out.println("------------------------"); // linha em branco para separar as linhas de produção
		}

		System.out.println("---Pedidos---");
		for (int i = 0; i < idPedido.length; i++) {
			System.out.println("ID Pedido: " + idPedido[i]);
			System.out.println("Data de Entrega: " + dataEntrega[i]);
			System.out.println("Preço Total: " + precoTotal[i]);
			System.out.println("Quantidade Total: " + qtddTotal[i]);
			System.out.println("----------------"); // linha em branco para separar os pedidos
		}

		System.out.println("---Produtos---");
		for (int i = 0; i < idProduto.length; i++) {
			System.out.println("ID Produto: " + idProduto[i]);
			System.out.println("Nome: " + nomeProduto[i]);
			System.out.println("Descrição: " + descricaoProduto[i]);
			System.out.println("Processo de Fabricação: " + processoFabricacao[i]);
			System.out.println("Preço: R$ " + precoProduto[i]);
			System.out.println("Quantidade: " + qtddProduto[i]);
			System.out.println("----------------"); // linha em branco para separar os produtos
		}
	}

	// Método para converter uma String no formato "dd/MM/yyyy" para Date
	public static Date convertStringToDate(String dateStr) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date date = format.parse(dateStr);
			return date;
		} catch (ParseException e) {
			System.out.println("Formato de data inválido. Usando data atual.");
			return new Date(); // Retorna a data atual em caso de erro de conversão
		}
	
	}
}