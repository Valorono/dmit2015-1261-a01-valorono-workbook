package dmit2015.view;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class EnrollmentBean implements Serializable {

    private String studentName;
    private String emailAddress;
    private String programName;
    private boolean onlineDelivery;

    public String submit() {

        return "enrollment-confirmation?faces-redirect=true";
    }

    public String getDeliveryMode() {
        if (onlineDelivery) {
            return "Online";
        }
        return "In-Person";
    }

    // generated getters/setters

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public boolean isOnlineDelivery() {
        return onlineDelivery;
    }

    public void setOnlineDelivery(boolean onlineDelivery) {
        this.onlineDelivery = onlineDelivery;
    }

    // clears the form
    public void clearForm() {
        this.studentName = null;
        this.emailAddress = null;
        this.programName = null;
        this.onlineDelivery = false;
    }
}
