package project;

public class UserWithRegistrationCard extends User {

	private RegistrationCard registrationCard;
	private int timeBalance;
	
	public UserWithRegistrationCard(String name, Location position, RegistrationCard card) {
		super(name, position);
		this.timeBalance = 0;
		this.registrationCard = card;
		// TODO Auto-generated constructor stub
	}
	
	public RegistrationCard getRegistrationCard() {
		return registrationCard;
	}

	public void setRegistrationCard(RegistrationCard registrationCard) {
		this.registrationCard = registrationCard;
	}
	
	public int getTimeBalance() {
		return timeBalance;
	}

	public void setTimeBalance(int timeBalance) {
		this.timeBalance = timeBalance;
	}
	
}
