package project;

public abstract class Card {

	private int cardNumber;
	private String userName;
	
	public Card(int number, String name) {
		setUserName(name);
		setCardNumber(number);
	}
	
	
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
