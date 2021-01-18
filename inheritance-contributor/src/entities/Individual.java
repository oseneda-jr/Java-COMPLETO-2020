package entities;

public class Individual extends Contributor {
	
	private double healthExpenses;
	
	private static double TAX = 0.25;
	private static double DISCOUNT = 0.50;
	
	public Individual() {
		super();
	}
	
	public Individual(String name, double annualIncome, double healthExpenses) {
		super(name, annualIncome);
		this.healthExpenses = healthExpenses;
	}

	public double getHealthExpenses() {
		return healthExpenses;
	}

	public void setHealthExpenses(double healthExpenses) {
		this.healthExpenses = healthExpenses;
	}
	
	@Override
	public double taxCalc() {
		if (this.healthExpenses > 0) {
			return (super.getAnnualIncome() * TAX) - (this.healthExpenses * DISCOUNT);
		}
		else {
			return (super.getAnnualIncome() * TAX);
		}
	}
}
