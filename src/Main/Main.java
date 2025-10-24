
package Main;


import dao.MongoDAO;
import dao.RedisDAO;
import java.util.Scanner;
import org.bson.Document;

public class Main {
    private static MongoDAO mongoDAO = new MongoDAO();
    private static RedisDAO redisDAO = new RedisDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    cadastrarBolo();
                    break;
                case 2:
                    listarBolos();
                    break;
                case 3:
                    atualizarBolo();
                    break;
                case 4:
                    deletarBolo();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    redisDAO.close();
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n=== Sistema de Vendas de Bolos ===");
        System.out.println("1. Cadastrar Bolo");
        System.out.println("2. Listar Bolos");
        System.out.println("3. Atualizar Bolo");
        System.out.println("4. Deletar Bolo");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarBolo() {
        try {
            System.out.print("Nome do bolo: ");
            String nome = scanner.nextLine();
            System.out.print("Preço: ");
            double preco = Double.parseDouble(scanner.nextLine());
            System.out.print("Quantidade: ");
            int quantidade = Integer.parseInt(scanner.nextLine());
            mongoDAO.criarBolo(nome, preco, quantidade);
            redisDAO.cacheBolo("ultimo_bolo", nome);
            System.out.println("Bolo cadastrado: " + nome);
        } catch (NumberFormatException e) {
            System.out.println("Erro: Preço ou quantidade inválidos!");
        }
    }

    private static void listarBolos() {
        System.out.println("Lista de Bolos:");
        for (Document doc : mongoDAO.getCollection().find()) {
            System.out.println(doc.toJson());
        }
        String ultimo = redisDAO.getCachedBolo("ultimo_bolo");
        if (ultimo != null) {
            System.out.println("Último bolo cacheado: " + ultimo);
        }
    }

    private static void atualizarBolo() {
        try {
            System.out.print("ID do bolo (copie do listar): ");
            String id = scanner.nextLine();
            System.out.print("Novo preço: ");
            double novoPreco = Double.parseDouble(scanner.nextLine());
            mongoDAO.atualizarBolo(id, novoPreco);
            System.out.println("Bolo atualizado!");
        } catch (NumberFormatException e) {
            System.out.println("Erro: Preço inválido!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: ID inválido ou não encontrado!");
        }
    }

    private static void deletarBolo() {
        System.out.print("ID do bolo (copie do listar): ");
        String id = scanner.nextLine();
        try {
            mongoDAO.deletarBolo(id);
            System.out.println("Bolo deletado com ID: " + id);
            redisDAO.cacheBolo("ultimo_bolo", null);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: ID inválido ou não encontrado!");
        }
    }
}