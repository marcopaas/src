package project;

public abstract class RegistrationCard extends Card {
	private int creditBalance; //how many free minutes the user currently has
	private int timeCredit; //how many extra minutes has the user earned until now
	
	public RegistrationCard(int number, User user) {
		super(number, user.getName());
		setCreditBalance(0);
		setTimeCredit(0);
	}
	
	public void AddExtraCredit() {
		setCreditBalance(getCreditBalance()+5);
		setTimeCredit(getTimeCredit()+5);
	}
	
	public void useExtraCredit(int numberOfConsumedMinutes) {
		setCreditBalance(getCreditBalance()-numberOfConsumedMinutes);
	}
	
	public int getCreditBalance() {
		return creditBalance;
	}
	public void setCreditBalance(int creditBalance) {
		this.creditBalance = creditBalance;
	}
	
	public int getTimeCredit() {
		return timeCredit;
	}
	public void setTimeCredit(int timeCredit) {
		this.timeCredit = timeCredit;
	}
	

	
	
}
