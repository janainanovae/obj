import java.util.Locale;
import java.util.Scanner;

public class CadastroCarros {

    private static final int LIMITE = 50;

    public static void main(String[] args) {
        Locale ptBR = Locale.forLanguageTag("pt-BR");

        // Locale pt-BR: o preço pode ser digitado com vírgula (ex.: 45000,50)
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(ptBR);

        // Vetor com capacidade para 50 carros
        Carro[] carros = new Carro[LIMITE];

        // Repete a pergunta até o usuário informar uma quantidade válida (1 a 50)
        int quantidade;
        do {
            System.out.print("Quantos carros deseja cadastrar (máximo " + LIMITE + ")? ");
            quantidade = scanner.nextInt();

            if (quantidade < 1 || quantidade > LIMITE) {
                System.out.println("Quantidade inválida! Informe um valor entre 1 e " + LIMITE + ".");
            }
        } while (quantidade < 1 || quantidade > LIMITE);

        // Consome a quebra de linha que sobrou após o nextInt()
        scanner.nextLine();

        // Cria cada objeto Carro e guarda no vetor
        for (int i = 0; i < quantidade; i++) {
            System.out.println();
            System.out.println("Carro " + (i + 1) + ":");

            System.out.print("Nome do modelo: ");
            String nome = scanner.nextLine();

            System.out.print("Preço: ");
            double preco = scanner.nextDouble();
            scanner.nextLine();

            carros[i] = new Carro(nome, preco);
        }

        // Exibe os nomes e calcula a soma dos preços
        System.out.println();
        System.out.println("===== Carros cadastrados =====");

        double somaPrecos = 0;
        for (int i = 0; i < quantidade; i++) {
            System.out.println((i + 1) + " - " + carros[i].getNome());
            somaPrecos += carros[i].getPreco();
        }

        System.out.println();
        System.out.println("Quantidade total de carros: " + quantidade);
        System.out.printf(ptBR, "Soma dos preços: R$ %.2f%n", somaPrecos);

        scanner.close();
    }
}
