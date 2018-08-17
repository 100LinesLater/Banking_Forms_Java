package class358013.jonathanhartmayer.finalassignment;

public class CheckingAccount extends Account{

	private double overdraftLimit;
	
	public CheckingAccount() {
		super();
	}
	
	public CheckingAccount(int id, double balance, double overdraftLimit) {
		super(id, balance);
		this.overdraftLimit = overdraftLimit;
	}

	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}
	
	@Override
	public String toString() {
		return "Checking " + super.toString() + "\n" +
				"Overdraft Limit: $-" + String.format("%.2f", overdraftLimit) + "\n";
	}
}
