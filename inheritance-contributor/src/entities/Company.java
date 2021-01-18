package entities;

public class Company extends Contributor{
	
	private int numEmployee;
		
	public Company() {
		super();
	}
	
	public Company(String name, double annualIncome, int numEmployee) {
		super(name, annualIncome);
		this.numEmployee = numEmployee;
	}

	public int getNumEmployee() {
		return numEmployee;
	}

	public void setNumEmployee(int numEmployee) {
		this.numEmployee = numEmployee;
	}
	
	@Override
	public double taxCalc() {
		if (this.numEmployee > 10) {
			return super.getAnnualIncome() * 0.14;
		}
		else {
			return super.getAnnualIncome() * 0.16;
		}
	}
}
