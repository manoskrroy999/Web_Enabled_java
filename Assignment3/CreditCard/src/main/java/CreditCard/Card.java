package CreditCard;



import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named("cardBean")
@RequestScoped
public class Card {
    private String cardNumber;
    private String message;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String submit() {
        message = "Credit Card " + cardNumber + " validated successfully!";
        return null;
    }
}
