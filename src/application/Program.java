package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Insira os dados do contrato");
		System.out.print("Número: ");
		int number = sc.nextInt();

		System.out.print("Data (dd/MM/aaaa): ");
		Date date = sdf.parse(sc.next());

		System.out.print("Valor do contrato:");
		double totalValue = sc.nextDouble();

		Contract contract = new Contract(number, date, totalValue);

		System.out.println("Insira o número de parcelas:");
		int n = sc.nextInt();
		ContractService cs = new ContractService(new PaypalService());

		cs.processContract(contract, n);

		System.out.println("Parcelas: ");
		for (Installment it : contract.getInstallments()) {
			System.out.println(it);
		}

		sc.close();
	}

}
