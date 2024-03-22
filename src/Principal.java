import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Instanciação de um objeto LinhaProducao
		LinhaProducao lpr = new LinhaProducao();

		// Impressão do menu de interação
		System.out.println("\n=== MENU DE INTERAÇÃO ===");
		System.out.println("1 - Gerenciar Produção");
		System.out.println("2 - Gerenciar Empresa");
		System.out.println("3 - Logout");
		System.out.println("0 - Encerrar Programa");

		// Declaração e inicialização da variável de opção do menu
		int opcao = -1;

		// Loop enquanto a opção não for 0 (encerrar programa)
		while (opcao != 0) {
			System.out.print("Escolha uma opção: ");
			opcao = sc.nextInt(); // Leitura da opção do usuário
			sc.nextLine(); // Limpar o buffer

			// Switch-case para lidar com as opções do menu

			switch (opcao) {
			case 1:
				// Opção para gerenciar a produção
				System.out.println("Opção 1 selecionada\n");
				System.out.println("===Gerenciar Produção===\n");

				// Chamada ao método menuInteracao da instância lpr
				lpr.menuInteracao();
				opcao = 0; // Define opcao como 0 para sair do loop
				break;
			case 2:
				// Opção para gerenciar a empresa
				System.out.println("Opção 2 selecionada\n");
				System.out.println("===Gerenciar Empresa===\n");

				// Solicitação e criação de operadores, máquinas, componentes, linhas de
				// produção, pedidos e produtos
				// Estes métodos lidam com a interação do usuário para criar instâncias desses
				// objetos e armazená-los em arrays

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

				// Exibição das informações criadas utilizando o método exibirInformacoes
				exibirInformacoes(idOperadores, nomesOperadores, idMaquinas, tiposMaquinas, statusMaquinas,
						temposAtividade, idComponentes, nomesComponentes, qtddComponentes, idLinhas, statusLinhas,
						temposCiclo, idPedido, dataEntrega, precoTotal, qtddTotal, idProduto, nomeProduto,
						descricaoProduto, processoFabricacao, precoProduto, qtddProdutos);
				break;
			case 3:
				// Opção para fazer logout
				System.out.println("Logout realizado com sucesso.");
				return; // Encerra o método exibirMenu e volta para o main
			case 0:
				// Opção para encerrar o programa
				System.out.println("Encerrando o programa. Até logo!");
				System.exit(0); // Encerra o programa
			default:
				// Caso o usuário escolha uma opção inválida
				System.out.println("Opção inválida. Digite novamente.");
				break;
			}
		}

	}

	// Função para solicitar uma quantidade de determinado tipo de entidade ao
	// usuário
	// Parâmetros:
	// - tipo: o tipo de entidade para o qual a quantidade está sendo solicitada
	// - sc: um objeto Scanner para entrada de dados
	// Retorna:
	// - a quantidade informada pelo usuário
	public static int solicitarQuantidade(String tipo, Scanner sc) {
		System.out.print("Informe a quantidade de " + tipo + ": "); // Solicita ao usuário a quantidade desejada
		return sc.nextInt(); // Retorna a quantidade fornecida pelo usuário
	}

	// Função para criar operadores com base na quantidade especificada
	// Parâmetros:
	// - qtdd: a quantidade de operadores a serem criados
	// - ids: um array para armazenar os IDs dos operadores criados
	// - nomes: um array para armazenar os nomes dos operadores criados
	// - sc: um objeto Scanner para entrada de dados
	public static void criarOperadores(int qtdd, int[] ids, String[] nomes, Scanner sc) {
		sc.nextLine(); // Limpa o buffer
		for (int i = 0; i < qtdd; i++) { // Loop para criar operadores
			int id;
			boolean idRepetido;
			do {
				System.out.print("Informe o ID do Operador " + (i + 1) + ": "); // Solicita ao usuário o ID do operador
				id = sc.nextInt(); // Lê o ID fornecido pelo usuário
				idRepetido = verificarRepeticao(id, ids); // Verifica se o ID fornecido já existe
				if (idRepetido) { // Se o ID já existe, solicita um novo ID
					System.out.println("ID já existe. Por favor, informe um novo ID.");
				}
			} while (idRepetido); // Repete o processo até que um ID único seja fornecido
			ids[i] = id; // Armazena o ID no array de IDs
			sc.nextLine(); // Limpa o buffer
			System.out.print("Informe o NOME do Operador " + (i + 1) + ": "); // Solicita ao usuário o nome do operador
			nomes[i] = sc.nextLine(); // Armazena o nome do operador no array de nomes
		}
	}

	// Função para criar máquinas com base na quantidade especificada
	// Parâmetros:
	// - qtdd: a quantidade de máquinas a serem criadas
	// - ids: um array para armazenar os IDs das máquinas criadas
	// - tipos: um array para armazenar os tipos das máquinas criadas
	// - status: um array para armazenar os status das máquinas criadas
	// - tempos: um array para armazenar os tempos de atividade das máquinas criadas
	// - sc: um objeto Scanner para entrada de dados
	public static void criarMaquinas(int qtdd, int[] ids, String[] tipos, String[] status, double[] tempos,
			Scanner sc) {
		sc.nextLine(); // Limpa o buffer
		for (int i = 0; i < qtdd; i++) { // Loop para criar máquinas
			int id;
			boolean idRepetido;
			do {
				System.out.print("Informe o ID da Máquina " + (i + 1) + ": "); // Solicita ao usuário o ID da máquina
				id = sc.nextInt(); // Lê o ID fornecido pelo usuário
				idRepetido = verificarRepeticao(id, ids); // Verifica se o ID fornecido já existe
				if (idRepetido) { // Se o ID já existe, solicita um novo ID
					System.out.println("ID já existe. Por favor, informe um novo ID.");
				}
			} while (idRepetido); // Repete o processo até que um ID único seja fornecido
			ids[i] = id; // Armazena o ID no array de IDs
			sc.nextLine(); // Limpa o buffer
			System.out.print("Informe o TIPO da Máquina " + (i + 1) + ": "); // Solicita ao usuário o tipo da máquina
			tipos[i] = sc.nextLine(); // Armazena o tipo da máquina no array de tipos

			// Solicita ao usuário o status da máquina e valida a entrada
			System.out.println("Selecione o STATUS da Máquina " + (i + 1) + ":");
			System.out.println("1 - Em processo");
			System.out.println("2 - Em manutenção");
			System.out.println("3 - Desativado");
			int opcao;
			do {
				System.out.print("Opção: ");
				opcao = sc.nextInt(); // Lê a opção fornecida pelo usuário
				switch (opcao) { // Define o status da máquina com base na opção selecionada
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
					System.out.println("Opção inválida."); // Mensagem de erro para opção inválida
					break;
				}
			} while (opcao < 1 || opcao > 3); // Repete o processo até que uma opção válida seja fornecida

			System.out.print("Informe o TEMPO DE ATIVIDADE da Máquina " + (i + 1) + ": "); // Solicita ao usuário o
																							// tempo de atividade da
																							// máquina
			tempos[i] = sc.nextDouble(); // Armazena o tempo de atividade no array de tempos
			sc.nextLine(); // Limpa o buffer
		}
	}

	// Função para criar componentes com base na quantidade especificada
	// Parâmetros:
	// - qtdd: a quantidade de componentes a serem criados
	// - ids: um array para armazenar os IDs dos componentes criados
	// - nomes: um array para armazenar os nomes dos componentes criados
	// - qtdds: um array para armazenar as quantidades dos componentes criados
	// - sc: um objeto Scanner para entrada de dados
	public static void criarComponentes(int qtdd, int[] ids, String[] nomes, int[] qtdds, Scanner sc) {
		sc.nextLine(); // Limpa o buffer
		for (int i = 0; i < qtdd; i++) { // Loop para criar componentes
			int id;
			boolean idRepetido;
			do {
				System.out.print("Informe o ID do Componente " + (i + 1) + ": "); // Solicita ao usuário o ID do
																					// componente
				id = sc.nextInt(); // Lê o ID fornecido pelo usuário
				idRepetido = verificarRepeticao(id, ids); // Verifica se o ID fornecido já existe
				if (idRepetido) { // Se o ID já existe, solicita um novo ID
					System.out.println("ID já existe. Por favor, informe um novo ID.");
				}
			} while (idRepetido); // Repete o processo até que um ID único seja fornecido
			ids[i] = id; // Armazena o ID no array de IDs
			sc.nextLine(); // Limpa o buffer
			System.out.print("Informe o NOME do Componente " + (i + 1) + ": "); // Solicita ao usuário o nome do
																				// componente
			nomes[i] = sc.nextLine(); // Armazena o nome do componente no array de nomes
			System.out.print("Informe a QUANTIDADE do Componente " + (i + 1) + ": "); // Solicita ao usuário a
																						// quantidade do componente
			qtdds[i] = sc.nextInt(); // Armazena a quantidade do componente no array de quantidades
			sc.nextLine(); // Limpa o buffer
		}
	}

	// Função para criar linhas de produção com base na quantidade especificada
	// Parâmetros:
	// - qtdd: a quantidade de linhas de produção a serem criadas
	// - ids: um array para armazenar os IDs das linhas de produção criadas
	// - status: um array para armazenar os status das linhas de produção criadas
	// - tempos: um array para armazenar os tempos de ciclo das linhas de produção
	// criadas
	// - sc: um objeto Scanner para entrada de dados
	public static void criarLinhasProducao(int qtdd, String[] ids, String[] status, double[] tempos, Scanner sc) {
		sc.nextLine(); // Limpa o buffer
		for (int i = 0; i < qtdd; i++) { // Loop para criar linhas de produção
			String id;
			boolean idRepetido;
			do {
				System.out.print("Informe o ID da Linha de Produção " + (i + 1) + ": "); // Solicita ao usuário o ID da
																							// linha de produção
				id = sc.nextLine(); // Lê o ID fornecido pelo usuário
				idRepetido = verificarRepeticao(id, ids); // Verifica se o ID fornecido já existe
				if (idRepetido) { // Se o ID já existe, solicita um novo ID
					System.out.println("ID já existe. Por favor, informe um novo ID.");
				}
			} while (idRepetido); // Repete o processo até que um ID único seja fornecido
			ids[i] = id; // Armazena o ID no array de IDs

			// Solicita ao usuário o status da linha de produção e valida a entrada
			System.out.println("Selecione o STATUS da Linha de Produção " + (i + 1) + ":");
			System.out.println("1 - Operando");
			System.out.println("2 - Parado");
			int opcao;
			do {
				System.out.print("Opção: ");
				opcao = sc.nextInt(); // Lê a opção fornecida pelo usuário
				switch (opcao) { // Define o status da linha de produção com base na opção selecionada
				case 1:
					status[i] = "Operando";
					break;
				case 2:
					status[i] = "Parado";
					break;
				default:
					System.out.println("Opção inválida."); // Mensagem de erro para opção inválida
					break;
				}
			} while (opcao < 1 || opcao > 2); // Repete o processo até que uma opção válida seja fornecida

			System.out.print("Informe o TEMPO DE CICLO da Linha de Produção " + (i + 1) + ": "); // Solicita ao usuário
																									// o tempo de ciclo
																									// da linha de
																									// produção
			tempos[i] = sc.nextDouble(); // Armazena o tempo de ciclo no array de tempos
			sc.nextLine(); // Limpa o buffer
		}
	}

	// Função para criar pedidos com base na quantidade especificada
	// Parâmetros:
	// - qtdd: a quantidade de pedidos a serem criados
	// - ids: um array para armazenar os IDs dos pedidos criados
	// - dataEntrega: um array para armazenar as datas de entrega dos pedidos
	// criados
	// - qtddTotal: um array para armazenar as quantidades totais dos pedidos
	// criados
	// - sc: um objeto Scanner para entrada de dados
	public static void criarPedido(int qtdd, int[] ids, Date[] dataEntrega, int[] qtddTotal, Scanner sc) {
		sc.nextLine(); // Limpa o buffer
		for (int i = 0; i < qtdd; i++) { // Loop para criar pedidos
			System.out.print("Informe o ID do pedido " + (i + 1) + ": "); // Solicita ao usuário o ID do pedido
			ids[i] = sc.nextInt(); // Lê o ID fornecido pelo usuário
			sc.nextLine(); // Limpa o buffer
			System.out.print("Informe a data de entrega do pedido " + (i + 1) + " (dd/MM/yyyy): "); // Solicita ao
																									// usuário a data de
																									// entrega do pedido
			String dataStr = sc.nextLine(); // Lê a data fornecida pelo usuário como uma string
			dataEntrega[i] = convertStringToDate(dataStr); // Converte a string de data para o formato Date e armazena
															// no array de datas
			System.out.print("Informe a quantidade total do pedido " + (i + 1) + ": "); // Solicita ao usuário a
																						// quantidade total do pedido
			qtddTotal[i] = sc.nextInt(); // Lê a quantidade total fornecida pelo usuário
			sc.nextLine(); // Limpa o buffer
		}
	}

	// Função para criar produtos com base na quantidade especificada
	// Parâmetros:
	// - qtdd: a quantidade de produtos a serem criados
	// - ids: um array para armazenar os IDs dos produtos criados
	// - nome: um array para armazenar os nomes dos produtos criados
	// - descricao: um array para armazenar as descrições dos produtos criados
	// - processoFabricacao: um array para armazenar os processos de fabricação dos
	// produtos criados
	// - preco: um array para armazenar os preços dos produtos criados
	// - qtddProdutos: um array para armazenar as quantidades dos produtos criados
	// - sc: um objeto Scanner para entrada de dados
	public static void criarProduto(int qtdd, int[] ids, String[] nome, String[] descricao, String[] processoFabricacao,
			double[] preco, int[] qtddProdutos, Scanner sc) {
		sc.nextLine(); // Limpa o buffer
		for (int i = 0; i < qtdd; i++) { // Loop para criar produtos
			int id;
			boolean idRepetido;
			do {
				System.out.print("Informe o ID do Produto " + (i + 1) + ": "); // Solicita ao usuário o ID do produto
				id = sc.nextInt(); // Lê o ID fornecido pelo usuário
				idRepetido = verificarRepeticao(id, ids); // Verifica se o ID fornecido já existe
				if (idRepetido) { // Se o ID já existe, solicita um novo ID
					System.out.println("ID já existe. Por favor, informe um novo ID.");
				}
			} while (idRepetido); // Repete o processo até que um ID único seja fornecido
			ids[i] = id; // Armazena o ID no array de IDs
			sc.nextLine(); // Limpa o buffer
			System.out.print("Informe o NOME do Produto " + (i + 1) + ": "); // Solicita ao usuário o nome do produto
			nome[i] = sc.nextLine(); // Lê e armazena o nome fornecido pelo usuário
			System.out.print("Informe a DESCRIÇÃO do Produto " + (i + 1) + ": "); // Solicita ao usuário a descrição do
																					// produto
			descricao[i] = sc.nextLine(); // Lê e armazena a descrição fornecida pelo usuário
			System.out.print("Informe o PROCESSO DE FABRICAÇÃO do Produto " + (i + 1) + ": "); // Solicita ao usuário o
																								// processo de
																								// fabricação do produto
			processoFabricacao[i] = sc.nextLine(); // Lê e armazena o processo de fabricação fornecido pelo usuário
			System.out.print("Informe o PREÇO do Produto " + (i + 1) + ": "); // Solicita ao usuário o preço do produto
			preco[i] = sc.nextDouble(); // Lê e armazena o preço fornecido pelo usuário
			System.out.print("Informe a QUANTIDADE do Produto " + (i + 1) + ": "); // Solicita ao usuário a quantidade
																					// do produto
			qtddProdutos[i] = sc.nextInt(); // Lê e armazena a quantidade fornecida pelo usuário
			sc.nextLine(); // Limpa o buffer
		}
	}

	// Função para verificar se um ID inteiro já existe em um array de IDs inteiros
	// Parâmetros:
	// - id: o ID a ser verificado
	// - ids: um array de IDs inteiros
	// Retorno:
	// - true se o ID já existe no array, false caso contrário
	public static boolean verificarRepeticao(int id, int[] ids) {
		for (int i : ids) { // Itera sobre cada ID no array
			if (id == i) { // Verifica se o ID fornecido é igual a um ID no array
				return true; // Retorna true se o ID já existe
			}
		}
		return false; // Retorna false se o ID não existe no array
	}

	// Função para verificar se uma string já existe em um array de strings
	// Parâmetros:
	// - id: a string a ser verificada
	// - ids: um array de strings
	// Retorno:
	// - true se a string já existe no array, false caso contrário
	public static boolean verificarRepeticao(String id, String[] ids) {
		for (String i : ids) { // Itera sobre cada string no array
			if (id.equals(i)) { // Verifica se a string fornecida é igual a uma string no array
				return true; // Retorna true se a string já existe
			}
		}
		return false; // Retorna false se a string não existe no array
	}

	// Função para exibir informações sobre operadores, máquinas, componentes,
	// linhas de produção, pedidos e produtos
	// Parâmetros:
	// - idsOperadores: array contendo os IDs dos operadores
	// - nomesOperadores: array contendo os nomes dos operadores
	// - idsMaquinas: array contendo os IDs das máquinas
	// - tiposMaquinas: array contendo os tipos das máquinas
	// - statusMaquinas: array contendo os status das máquinas
	// - temposAtividade: array contendo os tempos de atividade das máquinas
	// - idsComponentes: array contendo os IDs dos componentes
	// - nomesComponentes: array contendo os nomes dos componentes
	// - qtddsComponentes: array contendo as quantidades dos componentes
	// - idsLinhas: array contendo os IDs das linhas de produção
	// - statusLinhas: array contendo os status das linhas de produção
	// - temposCiclo: array contendo os tempos de ciclo das linhas de produção
	// - idPedido: array contendo os IDs dos pedidos
	// - dataEntrega: array contendo as datas de entrega dos pedidos
	// - precoTotal: array contendo os preços totais dos pedidos
	// - qtddTotal: array contendo as quantidades totais dos pedidos
	// - idProduto: array contendo os IDs dos produtos
	// - nomeProduto: array contendo os nomes dos produtos
	// - descricaoProduto: array contendo as descrições dos produtos
	// - processoFabricacao: array contendo os processos de fabricação dos produtos
	// - precoProduto: array contendo os preços dos produtos
	// - qtddProduto: array contendo as quantidades dos produtos
	public static void exibirInformacoes(int[] idsOperadores, String[] nomesOperadores, int[] idsMaquinas,
			String[] tiposMaquinas, String[] statusMaquinas, double[] temposAtividade, int[] idsComponentes,
			String[] nomesComponentes, int[] qtddsComponentes, String[] idsLinhas, String[] statusLinhas,
			double[] temposCiclo, int[] idPedido, Date[] dataEntrega, double[] precoTotal, int[] qtddTotal,
			int[] idProduto, String[] nomeProduto, String[] descricaoProduto, String[] processoFabricacao,
			double[] precoProduto, int[] qtddProduto) {
		// Exibe informações sobre operadores
		System.out.println("\n---Operadores---");
		for (int i = 0; i < idsOperadores.length; i++) {
			System.out.println("ID: " + idsOperadores[i]);
			System.out.println("Nome: " + nomesOperadores[i]);
			System.out.println("----------------"); // linha em branco para separar os operadores
		}

		// Exibe informações sobre máquinas
		System.out.println("---Máquinas---");
		for (int i = 0; i < idsMaquinas.length; i++) {
			System.out.println("ID: " + idsMaquinas[i]);
			System.out.println("Tipo: " + tiposMaquinas[i]);
			System.out.println("Status: " + statusMaquinas[i]);
			System.out.println("Tempo de Atividade: " + temposAtividade[i] + " Horas");
			System.out.println("--------------"); // linha em branco para separar as máquinas
		}

		// Exibe informações sobre componentes
		System.out.println("---Componentes---");
		for (int i = 0; i < idsComponentes.length; i++) {
			System.out.println("ID: " + idsComponentes[i]);
			System.out.println("Nome: " + nomesComponentes[i]);
			System.out.println("Quantidade: " + qtddsComponentes[i]);
			System.out.println("-----------------"); // linha em branco para separar os componentes
		}

		// Exibe informações sobre linhas de produção
		System.out.println("---Linhas de Produção---");
		for (int i = 0; i < idsLinhas.length; i++) {
			System.out.println("ID: " + idsLinhas[i]);
			System.out.println("Status: " + statusLinhas[i]);
			System.out.println("Tempo de Ciclo: " + temposCiclo[i] + " Horas");
			System.out.println("------------------------"); // linha em branco para separar as linhas de produção
		}

		// Exibe informações sobre pedidos
		System.out.println("---Pedidos---");
		for (int i = 0; i < idPedido.length; i++) {
			System.out.println("ID Pedido: " + idPedido[i]);
			System.out.println("Data de Entrega: " + dataEntrega[i]);
			System.out.println("Preço Total: " + precoTotal[i]);
			System.out.println("Quantidade Total: " + qtddTotal[i]);
			System.out.println("----------------"); // linha em branco para separar os pedidos
		}

		// Exibe informações sobre produtos
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
	// Parâmetro:
	// - dateStr: String contendo a data no formato "dd/MM/yyyy"
	// Retorna:
	// - Um objeto Date representando a data convertida
	public static Date convertStringToDate(String dateStr) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy"); // Cria um formato de data específico
		try {
			Date date = format.parse(dateStr); // Tenta fazer o parsing da string para um objeto Date
			return date; // Retorna o objeto Date se a conversão for bem-sucedida
		} catch (ParseException e) { // Captura a exceção se ocorrer um erro de parsing
			System.out.println("Formato de data inválido. Usando data atual."); // Informa sobre o formato inválido
			return new Date(); // Retorna a data atual em caso de erro de conversão
		}
	}

}
