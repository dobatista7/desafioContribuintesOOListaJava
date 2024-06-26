package application;

import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<TaxPayer> taxPayers = new ArrayList<>();

        System.out.print("Quantos contribuintes você vai digitar? ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            System.out.println();
            System.out.println("Digite os dados do " + i + "o contribuinte: ");
            System.out.print("Renda anual com salário: ");
            double salaryIncome = sc.nextDouble();
            System.out.print("Renda anual com prestação de serviço: ");
            double serviceIncome = sc.nextDouble();
            System.out.print("Renda anual com ganho de capital: ");
            double capitalIncome = sc.nextDouble();
            System.out.print("Gastos médicos: ");
            double healthSpending = sc.nextDouble();
            System.out.print("Gastos educacionais: ");
            double educationSpending = sc.nextDouble();

            TaxPayer taxPayer = new TaxPayer(salaryIncome,serviceIncome,capitalIncome,healthSpending,educationSpending);
            taxPayers.add(taxPayer);
        }

        for (int i = 0; i < taxPayers.size(); i++) {
            System.out.println();
            TaxPayer taxPayer = taxPayers.get(i);
            System.out.println("Resumo do " + (i + 1) + "o contribuinte:");
            System.out.printf("Imposto bruto total: %.2f%n", taxPayer.grossTax());
            System.out.printf("Abatimento: %.2f%n", taxPayer.taxRebate());
            System.out.printf("Imposto devido: %.2f%n", taxPayer.netTax());
        }

        sc.close();
        }
    }
