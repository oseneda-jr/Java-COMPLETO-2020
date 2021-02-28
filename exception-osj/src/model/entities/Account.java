package model.entities;

import model.exceptions.DomainException;

public class Account {
	
	private int number;
	private String holder;
	private double balance;
	private double withdrawLimit;
	
	public Account() {
	}

	public Account(int number, String holder, double initialBalance, double withdrawLimit) {
		super();
		this.number = number;
		this.holder = holder;
		this.balance = initialBalance;
		this.withdrawLimit = withdrawLimit;
	}

	public int getNumber() {
		return number;
	}

	
	public String getHolder() {
		return holder;
	}

	public double getBalance() {
		return balance;
	}

	
	public double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public void withdraw(double value)  {
		if (value > this.withdrawLimit) {
			throw new DomainException("The ammount exceeds withdraw limit");
		}
		else if (value > this.balance) {
				throw new DomainException("Not enough balance");
		}
		else {
			this.balance -= value;
		}
	}

	@Override
	public String toString() {
		return "New balance = " + String.format("%.2f", getBalance());
	}
	
	
}
	