package project;

public abstract class RegistrationCard extends Card {
	private int timeCredit; //how many free minutes the user currently has
	
	
	public RegistrationCard(String username) {
		super(username);
		setTimeCredit(0);
	}
	
	// public void AddExtraCredit() {
	// 	setCreditBalance(getCreditBalance()+5);
	// 	setTimeCredit(getTimeCredit()+5);
	// }
	
	// public void useExtraCredit(int numberOfConsumedMinutes) {
	// 	setCreditBalance(getCreditBalance()-numberOfConsumedMinutes);
	// }
	
	
	
	public int getTimeCredit() {
		return timeCredit;
	}
	public void setTimeCredit(int timeCredit) {
		this.timeCredit = timeCredit;
	}

	public void print(){
		System.out.println("The card wass successfully created with the following details:");
		super.print();
		System.out.println("Time Credit: " + getTimeCredit());
	}
	

	
	
}
