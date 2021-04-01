package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import domain.entities.Contract;
import domain.services.InstallmentService;
import domain.services.Paypal;
import domain.entities.Installment;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Contract Data");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		sc.nextLine();
		System.out.print("Date (dd/MM/yyyy): ");
		String dates = sc.nextLine();
		Date date = sdf.parse(dates);
		System.out.print("Contract value: ");
		Double value = sc.nextDouble();
		Contract contract = new Contract(number, date, value);
		
		System.out.print("Enter number of installments: ");
		Integer months = sc.nextInt();
		
		InstallmentService installmentService = new InstallmentService(new Paypal());
		
		installmentService.generateInstallment(contract, months);
		
		System.out.println("Installments:");
		for (Installment x : contract.getInstallments()) {
			System.out.println(x);
		}
				
		sc.close();
	}
}
