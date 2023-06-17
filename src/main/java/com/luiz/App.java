package com.luiz;

import java.util.Scanner;

// import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.luiz.dao.ClienteDAO;
import com.luiz.modelos.Alcoolica;
import com.luiz.modelos.Cliente;
import com.luiz.modelos.Produto;
import com.luiz.dao.ProdutoDAO;
import com.luiz.modelos.Pedido;
import com.luiz.dao.PedidoDAO;
import com.luiz.dao.FuncionarioDAO;
import com.luiz.modelos.Funcionario;
import com.luiz.modelos.NaoAlcoolica;

public class App {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        Scanner scanner = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        System.out.println("----- BEM VINDO A LOJINHA DE BEBIDAS DO LUIZ !!! -----");

        System.out.println("Selecione uma opção:");
        System.out.println("1 - Clientes");
        System.out.println("2 - Produtos");
        System.out.println("3 - Pedidos");
        System.out.println("4 - Funcionarios");

        System.out.println("5 - Encerrar Programa ");
        

        int opcao = scanner.nextInt();

        do{
            //SWITCH MENU PRINCIPAL
        switch (opcao) {

            case 1:

                System.out.println("Selecione um procedimento:");
                System.out.println("1 - Cadastrar Cliente");
                System.out.println("2 - Listar Clientes ");
                System.out.println("3 - Atualizar Cliente ");
                System.out.println("4 - Excluir Cliente ");

                int opcao_cliente = scanner.nextInt();

                //SWITCH MENU CLIENTE
                switch (opcao_cliente) {

                    case 1:
                        cadastrarCliente(scanner, clienteDAO);
                        break;

                    case 2:
                        listarClientes(clienteDAO);
                        break;

                    case 3:
                        atualizarCliente(scanner, clienteDAO);
                        break;

                    case 4:
                        excluirCliente(scanner, clienteDAO);
                        break;

                    default:
                        System.out.println("Opção inválida");

                }

            case 2:

                System.out.println("Selecione um procedimento:");
                System.out.println("1 - Cadastrar Produto");
                System.out.println("2 - Listar Produtos ");
                System.out.println("3 - Atualizar Produto ");
                System.out.println("4 - Excluir Produto ");


                int opcao_produto = scanner.nextInt();;
                switch (opcao_produto) {

                    case 1:
                        cadastrarProduto(scanner, produtoDAO);
                        break;

                    case 2:
                        listarProduto(produtoDAO);
                        break;

                    case 3:
                        atualizarProduto(scanner, produtoDAO);
                        break;

                    case 4:
                        excluirProduto(scanner, produtoDAO);
                        break;

                    default:
                        System.out.println("Opção inválida");

                }

                break;
            case 3:

                System.out.println("Selecione um procedimento:");
                System.out.println("1 - Cadastrar Pedido");
                System.out.println("2 - Listar Pedidos ");
                System.out.println("3 - Atualizar Pedido ");
                System.out.println("4 - Excluir Pedido ");


                int opcao_pedido = scanner.nextInt();
                switch (opcao_pedido) {

                    case 1:
                        cadastrarPedido(scanner, pedidoDAO);
                        break;

                    case 2:
                        listarPedido(pedidoDAO);
                        break;

                    case 3:
                       atualizarPedido(scanner, pedidoDAO);
                        break;

                    case 4:
                        excluirPedido(scanner, pedidoDAO);
                        break;

                    default:
                        System.out.println("Opção inválida");

                }

                break;

                case 4:

                System.out.println("Selecione um procedimento:");
                System.out.println("1 - Cadastrar Funcionario");
                System.out.println("2 - Listar Funcionarios ");
                System.out.println("3 - Atualizar Funcionario ");
                System.out.println("4 - Excluir Funcionario ");


                int opcao_funcionario = scanner.nextInt();
                switch (opcao_funcionario) {

                    case 1:
                        cadastrarFuncionario(scanner, funcionarioDAO);
                        break;

                    case 2:
                        listarFuncionario(funcionarioDAO);
                        break;

                    case 3:
                        atualizarFuncionario(scanner, funcionarioDAO);
                        break;

                    case 4:
                        excluirFuncionario(scanner,funcionarioDAO);
                        break;

                    default:
                        System.out.println("Opção inválida");

                }

                break;

            
            default:
                System.out.println("Opção inválida");
        }
    }while(opcao != 5);

        emf.close();
    }

    //FUNÇOES


    //FUNCOES CRUD - CLIENTE
    //concluido

    private static void cadastrarCliente(Scanner scanner, ClienteDAO clienteDAO) {
        System.out.println("Cadastro de Cliente");


        System.out.println("Informe o nome do Cliente:");
        scanner.nextLine(); // Limpar o buffer
        String nome = scanner.nextLine();

        System.out.println("Informe a idade cliente:");
        int idade = scanner.nextInt();

        Cliente cliente = new Cliente(nome, idade);
        clienteDAO.salvarCliente(cliente);

        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void listarClientes(ClienteDAO clienteDAO) {
        System.out.println("Lista de clientes:");

        for (Cliente cliente : clienteDAO.buscarTodosClientes()) {
            System.out.println("ID :" + cliente.getId());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Idade: " + cliente.getIdade());
            System.out.println("--------------------");
        }
    }

    private static void atualizarCliente(Scanner scanner, ClienteDAO clienteDAO) {
        System.out.println("Atualizar Cliente");

        System.out.println("Informe o ID do Cliente a ser atualizado:");
        Long id = scanner.nextLong();

        Cliente cliente = clienteDAO.buscarClientePorId(id);

        if (cliente != null) {

            System.out.println("Informe o novo nome do cliente:");
            scanner.nextLine(); // Limpar o buffer
            String nome = scanner.nextLine();

            System.out.println("Informe a nova idade do cliente:");
            int idade = scanner.nextInt();

            cliente.setNome(nome);
            cliente.setIdade(idade);

            clienteDAO.atualizarCliente(cliente);
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    private static void excluirCliente(Scanner scanner, ClienteDAO clienteDAO) {
        System.out.println("Excluir Cliente");

        System.out.println("Informe o ID do Cliente a ser excluído:");
        Long id = scanner.nextLong();

        Cliente cliente = clienteDAO.buscarClientePorId(id);

        if (cliente != null) {
            long codigo = cliente.getId();
            String nome = cliente.getNome();
            int idade = cliente.getIdade();

            clienteDAO.excluirCliente(cliente);

            System.out.println("Cliente excluído com sucesso!");
            System.out.println("Informações do Cliente excluído:");
            System.out.println("ID: " + codigo);
            System.out.println("Nome: " + nome);
            System.out.println("Idade: " + idade);
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    //FUNCOES CRUD - PRODUTO

    private static void cadastrarProduto(Scanner scanner, ProdutoDAO produtoDAO) {
        System.out.println("Cadastro de Produto");

        System.out.println("Informe o nome do Produto:");
        scanner.nextLine(); // Limpar o buffer
        String nomeProduto = scanner.nextLine();

        System.out.println("Informe a qtda de litros do Produto:");
        int litros = scanner.nextInt();

        System.out.println("Informe o preco do Produto:");
        int preco = scanner.nextInt();

        System.out.println("Informe o tipo do Produto:");
        System.out.println("1 - Alcoolico");
        System.out.println("2 - Não Alcoolico");
        int tipoSelecionado = scanner.nextInt();

        scanner.nextLine(); // Limpar o buffer

    switch (tipoSelecionado) {
        case 1:
            System.out.println("Informe o teor alcoolico :");
            int percentAlcool = scanner.nextInt();

            Alcoolica alcoolica = new Alcoolica(nomeProduto, litros, percentAlcool, preco);
            produtoDAO.salvarProduto(alcoolica);
            break;

        case 2:
            System.out.println("Informe o sabor do produtos :");
            String sabor = scanner.nextLine();

            NaoAlcoolica naoAlcoolica = new NaoAlcoolica(nomeProduto, litros, sabor, preco);
            produtoDAO.salvarProduto(naoAlcoolica);
            break;

        default:
            System.out.println("Opção inválida.");
            break;
    }


        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void listarProduto(ProdutoDAO produtoDAO) {
        System.out.println("Lista de Produtos:");



        for (Produto produto : produtoDAO.buscarTodosProdutos()) {
            System.out.println("ID :" + produto.getId());
            System.out.println("Nome: " + produto.getNomeProduto());
            System.out.println("litros: " + produto.getLitros());
            System.out.println("preço: " + produto.getPreco());
            
        }
       
    }

    private static void atualizarProduto(Scanner scanner, ProdutoDAO produtoDAO) {
        System.out.println("Atualizar Produto");

        System.out.println("Informe o ID do Produto a ser atualizado:");
        Long id = scanner.nextLong();

        Produto produto = produtoDAO.buscarProdutoPorId(id);

        if (produto != null) {

            System.out.println("Informe o novo nome do Produto:");
            scanner.nextLine(); // Limpar o buffer
            String nome = scanner.nextLine();

            System.out.println("Informe a nova litragem do Produto:");
            int litros = scanner.nextInt();

            System.out.println("Informe o novo preco do Produto:");
            int preco = scanner.nextInt();

            produto.setNomeProduto(nome);
            produto.setLitros(litros);
            produto.setPreco(preco);

            produtoDAO.atualizarProduto(produto);
            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    private static void excluirProduto(Scanner scanner, ProdutoDAO produtoDAO) {
        System.out.println("Excluir Produto");

        System.out.println("Informe o ID do Produto a ser excluído:");
        Long id = scanner.nextLong();

        Produto produto = produtoDAO.buscarProdutoPorId(id);

        if (produto != null) {
            long codigo = produto.getId();
            String nome = produto.getNomeProduto();
            int litros = produto.getLitros();
            int preco = produto.getPreco();

            produtoDAO.excluirProduto(produto);

            System.out.println("Produto excluído com sucesso!");
            System.out.println("Informações do Produto excluído:");
            System.out.println("ID: " + codigo);
            System.out.println("Nome do Produto: " + nome);
            System.out.println("litros: " + litros);
            System.out.println("preco: " + preco);
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    //FUNCOES CRUD - PEDIDO

     private static void cadastrarPedido(Scanner scanner, PedidoDAO pedidoDAO) {
        System.out.println("Cadastro de Pedido");

       
    }

    private static void listarPedido(PedidoDAO pedidoDAO) {
        System.out.println("Lista de Pedido:");

    }

    private static void atualizarPedido(Scanner scanner, PedidoDAO pedidoDAO) {
        System.out.println("Atualizar Pedido");

      
    }

    private static void excluirPedido(Scanner scanner, PedidoDAO pedidoDAO) {
        System.out.println("Pedido Cliente");

    }

    //FUNCOES CRUD - FUCIONARIO
    //concluido

     private static void cadastrarFuncionario(Scanner scanner, FuncionarioDAO funcionarioDAO) {
        System.out.println("Cadastro de Funcionario");


        System.out.println("Informe o nome do Funcionario:");
        scanner.nextLine(); // Limpar o buffer
        String nome = scanner.nextLine();

        System.out.println("Informe a idade Funcionario:");
        int idade = scanner.nextInt();

        Funcionario funcionario = new Funcionario(nome, idade);
        funcionarioDAO.salvarFuncionario(funcionario);

        System.out.println("Funcionario cadastrado com sucesso!");
    }

    private static void listarFuncionario(FuncionarioDAO funcionarioDAO) {
        System.out.println("Lista de Funcionarios:");

        for (Funcionario funcionario : funcionarioDAO.buscarTodosFuncionario()) {
            System.out.println("ID :" + funcionario.getId());
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Idade: " + funcionario.getIdade());
            System.out.println("--------------------");
        }
    }

    private static void atualizarFuncionario(Scanner scanner, FuncionarioDAO funcionarioDAO) {
        System.out.println("Atualizar Funcionario");

        System.out.println("Informe o ID do Funcionario a ser atualizado:");
        Long id = scanner.nextLong();

        Funcionario funcionario = funcionarioDAO.buscarFuncionarioPorId(id);

        if (funcionario != null) {

            System.out.println("Informe o novo nome do Funcionario:");
            scanner.nextLine(); // Limpar o buffer
            String nome = scanner.nextLine();

            System.out.println("Informe a nova idade do Funcionario:");
            int idade = scanner.nextInt();

            funcionario.setNome(nome);
            funcionario.setIdade(idade);

            funcionarioDAO.atualizarFuncionario(funcionario);
            System.out.println("Funcionario atualizado com sucesso!");
        } else {
            System.out.println("Funcionario não encontrado!");
        }
    }

    private static void excluirFuncionario(Scanner scanner, FuncionarioDAO funcionarioDAO) {
        System.out.println("Excluir Funcionario");

        System.out.println("Informe o ID do Funcionario a ser excluído:");
        Long id = scanner.nextLong();

        Funcionario funcionario = funcionarioDAO.buscarFuncionarioPorId(id);

        if (funcionario != null) {
            long codigo = funcionario.getId();
            String nome = funcionario.getNome();
            int idade = funcionario.getIdade();

            funcionarioDAO.excluirFuncionario(funcionario);

            System.out.println("Funcionario excluído com sucesso!");
            System.out.println("Informações do Funcionario excluído:");
            System.out.println("ID: " + codigo);
            System.out.println("Nome: " + nome);
            System.out.println("Idade: " + idade);
        } else {
            System.out.println("Funcionario não encontrado!");
        }
    }
}
