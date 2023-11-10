package application;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter the contract data:");
        System.out.print("Number: ");
        int contractNumber = sc.nextInt();
        sc.nextLine();

        System.out.print("Date (dd/mm/yyyy): ");
        LocalDate contractDate = LocalDate.parse(sc.nextLine(), fmt);

        System.out.print("Contract value: ");
        double contractValue = sc.nextDouble();

        Contract contract = new Contract(contractNumber, contractDate, contractValue);

        System.out.print("Enter the number of installments: ");
        int installments = sc.nextInt();

        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract, installments);
        System.out.println();

        System.out.println("Installments:");
        for (Installment installment : contract.getInstallments()) {
            System.out.println(installment);
        }

        sc.close();
    }
}
