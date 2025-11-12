package CreditCard;


import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator("creditCardValidator")
public class CardValidator implements Validator<Object> {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String cardNumber = value.toString().replaceAll("\\s+", "");

        // Simple validation: must be 16 digits and numeric
        if (!cardNumber.matches("\\d{16}")) {
            FacesMessage msg = new FacesMessage("Invalid Credit Card Number", 
                    "Credit card must be exactly 16 digits.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

        // Example Luhn algorithm (basic checksum)
        if (!isValidLuhn(cardNumber)) {
            FacesMessage msg = new FacesMessage("Invalid Credit Card Number", 
                    "Failed Luhn check.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

    private boolean isValidLuhn(String cardNumber) {
        int sum = 0;
        boolean alternate = false;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(cardNumber.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) n -= 9;
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }
}
