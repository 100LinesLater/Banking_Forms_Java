package class358013.jonathanhartmayer.finalassignment;

import java.util.Date;

public class Account {

	protected int id;
	protected double balance;
	protected double annualInterestRate;
	protected Date dateCreated;
	
	public Account() {
		balance = 0;
		annualInterestRate = 0;
		dateCreated = new Date();	
	}
	
	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
		annualInterestRate = 0;
		dateCreated = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate / 100;
	}

	public Date getDateCreated() {
		return dateCreated;
	}
	
	public double getMonthlyInterestRate() {
		return this.getAnnualInterestRate() / 12;
	}
	
	public double getMonthlyInterest() {
		return this.getMonthlyInterestRate() * balance;
	}
	
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	@Override
	public String toString() {
		return "Account ID: " + id + "\n" +
				"Date Created: " + dateCreated.toString() + "\n" +
				"Balance: $" + String.format("%.2f", balance) + "\n" +
				"Monthly Interest: $" + String.format("%.2f", this.getMonthlyInterest());
	}
}
