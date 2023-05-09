package project;

public class UserWithRegistrationCard extends User {
	
	public UserWithRegistrationCard(String name, Location position, CreditCard creditCard) {
		super(name, position, creditCard);
		// TODO Auto-generated constructor stub
	}

	private RegistrationCard registrationCard;

	public RegistrationCard getRegistrationCard() {
		return registrationCard;
	}

	public void setRegistrationCard(RegistrationCard registrationCard) {
		this.registrationCard = registrationCard;
	}
	
	
}
