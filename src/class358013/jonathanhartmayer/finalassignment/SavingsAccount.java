package class358013.jonathanhartmayer.finalassignment;

public class SavingsAccount extends Account {

	public SavingsAccount() {
		super();
	}
	
	public SavingsAccount(int id, double balance) {
		super(id, balance);
	}
	
	@Override
	public String toString() {
		return "Savings " + super.toString() +"\n";
	}
}
