package stateLanguage;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.faces.event.ValueChangeEvent;
import java.io.Serializable;

@Named("stateBean")
@SessionScoped
public class StateLang implements Serializable {
    private String selectedState;
    private String language;

    public String getSelectedState() {
        return selectedState;
    }

    public void setSelectedState(String selectedState) {
        this.selectedState = selectedState;
    }

    public String getLanguage() {
        return language;
    }

    // Value Change Listener Method
    public void stateChanged(ValueChangeEvent event) {
        selectedState = event.getNewValue().toString();

        switch (selectedState) {
            case "Tamil Nadu":
                language = "Tamil";
                break;
            case "Maharashtra":
                language = "Marathi";
                break;
            case "Karnataka":
                language = "Kannada";
                break;
            case "Kerala":
                language = "Malayalam";
                break;
            case "Gujarat":
                language = "Gujarati";
                break;
            default:
                language = "Unknown";
        }
    }
}