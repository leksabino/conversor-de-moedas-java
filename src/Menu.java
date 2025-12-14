import java.util.Scanner;
import java.util.List;

public class Menu {

    private Scanner leitura = new Scanner(System.in);
    private Conversor conversor = new Conversor();

    public void exibir() {

        int opcao;

        do {
            System.out.println("""
                    ==============================
                    CONVERSOR DE MOEDAS
                    1 - USD → BRL
                    2 - BRL → USD
                    3 - EUR → BRL
                    4 - BRL → EUR
                    5 - USD → EUR
                    6 - EUR → USD
                    7 - Ver histórico
                    0 - Sair
                    ==============================
                    """);

            System.out.print("Digite um número de 1 a 6 para conversão ou 0 para sair: ");
            opcao = leitura.nextInt();

            if (opcao == 0) {
                System.out.println("Programa encerrado.");
                break;
            }

            if (opcao < 1 || opcao > 7) {
                System.out.println("Opção inválida. Digite um número entre 1 e 6.");
                continue;
            }

            if (opcao == 7) {
                List<Conversao> historico = conversor.getHistorico();
                if (historico.isEmpty()) {
                    System.out.println("Nenhuma conversão realizada ainda.");
                } else {
                    historico.forEach(System.out::println);
                }
                continue;
            }

            System.out.print("Digite o valor: ");
            double valor = leitura.nextDouble();

            Conversao conversao = conversor.converter(opcao, valor);

            System.out.printf("Valor convertido: %.2f%n", conversao.getValorConvertido());

        } while (true);
    }
}
