package commons;

public class CreditCard {
	public String getTypeOfCreditCard() {
		return typeOfCreditCard;
	}
	public void setTypeOfCreditCard(String typeOfCreditCard) {
		this.typeOfCreditCard = typeOfCreditCard;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getCardCode() {
		return cardCode;
	}
	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}
	
	public CreditCard(String typeOfCreditCard, String cardHolderName, String cardNumber, String expirationDate, String cardCode) {
		this.typeOfCreditCard = typeOfCreditCard;
		this.cardHolderName = cardHolderName;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.cardCode = cardCode;
	}
	
	private String typeOfCreditCard;
	private String cardHolderName;
	private String cardNumber;
	private String expirationDate;
	private String cardCode;
}
