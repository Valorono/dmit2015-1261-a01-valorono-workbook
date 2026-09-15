package dmit2015.view;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class GreetingBean {

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGreetingMessage() {

        if (firstName == null || lastName == null || firstName.isBlank() || lastName.isBlank()) {
            return "";
        }

        //return "Welcome " + firstName + " to DMIT2015!";

        return String.format("Welcome %s %s to DMIT2015!", firstName, lastName);
        // string formatting is preferred in industry
    }
}
