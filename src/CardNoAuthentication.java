
public class CardNoAuthentication {
	User client = new User();

	public boolean validate(String cardNo) {
		if(cardNo.equalsIgnoreCase(client.getCardNo()))
            return true;
		else
			return false;
	}
}
