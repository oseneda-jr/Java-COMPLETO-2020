package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Contributor;
import entities.Individual;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Contributor> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char tipCont = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double annualIncome = sc.nextDouble();
			if (tipCont == 'c') {
				System.out.print("Number of employees: ");
				int numEmployee = sc.nextInt();
				list.add(new Company(name, annualIncome, numEmployee));
			}
			else {
				System.out.print("Health expenditures: ");
				double healthExpenditure = sc.nextDouble();
				list.add(new Individual(name, annualIncome, healthExpenditure));
			}
		}
		
		System.out.println("\nTAXES PAID:");
		
		double sum = 0.0;
		for (Contributor c : list) {
			sum += c.taxCalc();
			System.out.println(c.getName() + ": $ " + String.format("%.2f", c.taxCalc()));
		}
		
		System.out.println("\nTOTAL TAXES: $ " + String.format("%.2f", sum));
		
		sc.close();
	}
}
