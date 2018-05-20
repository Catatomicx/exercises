
public class BankAccount {
	String name;
	double balance;
	double transactionFee = 0.0;

	public void deposit(double amount) {
		balance = balance + amount;
	} 
	
	public void withdraw(double amount) {
		if(balance - amount >= 0)
			balance = balance - amount;
		if(balance - transactionFee >= 0)
			balance -= transactionFee;
	} 
	
	public String toString() {
		return name + ", $" + balance;
	}
	
	public void transfer(BankAccount ba, double money) {
	    if(balance < 5 || money <= 0)
	        return;
	    
	    if(balance < 5 + money) {
	        ba.deposit(balance - 5);
	        this.withdraw(balance);
	    } else {
	        ba.deposit(money);
	        this.withdraw(5 + money);
	    }
	}
}