import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conversor conversor = new Conversor();
        String moedaBase = "";
        String moedaAlvo = "";

        while (true) {
            System.out.println("*******************************************************\n" +
                    "Seja bem-vindo(a) ao Conversor de Moeda =]\n" +
                    "1-) Dólar =>> Peso argentino\n" +
                    "2-) Peso argentino =>> Dólar\n" +
                    "3-) Dólar =>> Real brasileiro\n" +
                    "4-) Real brasileiro =>> Dólar\n" +
                    "5-) Dólar =>> Peso colombiano\n" +
                    "6-) Peso colombiano =>> Dólar\n" +
                    "7-) Sair\n" +
                    "Escolha uma opção válida: \n" +
                    "*******************************************************\n");
            int opcao = scanner.nextInt();

            if (opcao >= 1 && opcao <= 6) {


                System.out.println("Digite u valor que deseja converter: ");
                double valor = scanner.nextDouble();

                switch (opcao) {
                    case 1:
                        moedaBase = "USD";
                        moedaAlvo = "ARS";
                        break;
                    case 2:
                        moedaBase = "ARS";
                        moedaAlvo = "USD";
                        break;
                    case 3:
                        moedaBase = "USD";
                        moedaAlvo = "BRL";
                        break;
                    case 4:
                        moedaBase = "BRL";
                        moedaAlvo = "USD";
                        break;
                    case 5:
                        moedaBase = "USD";
                        moedaAlvo = "COP";
                        break;
                    case 6:
                        moedaBase = "COP";
                        moedaAlvo = "USD";
                        break;
                }

                double valorConvertido = conversor.converterMoeda(moedaBase, moedaAlvo, valor).conversion_result();
                System.out.printf("O valor %.5f %s corresponde ao valor final de %.5f %s%n",
                        valor, moedaBase, valorConvertido, moedaAlvo);

            } else if (opcao == 7) {
                System.out.println("Saindo.......");
                break;
            } else {
                System.out.println("Opção inválida.");
                break;
            }
        }
    }
}

