package dmit2015.view;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ViewScoped
public class CourseRegistrationBean implements Serializable {

    private String studentName;
    private String courseName;
    private boolean onlineDelivery;

    private String emailAddress;

    public void submit() {

        String deliveryMode =
                onlineDelivery ? "Online" : "In-Person";

        FacesMessage message = new FacesMessage(
                FacesMessage.SEVERITY_INFO,
                "Registration Submitted",
                studentName + " with email: " + emailAddress + " is registered for "
                        + courseName + " (" + deliveryMode + ")");

        FacesContext.getCurrentInstance()
                .addMessage(null, message);
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public boolean isOnlineDelivery() {
        return onlineDelivery;
    }

    public void setOnlineDelivery(boolean onlineDelivery) {
        this.onlineDelivery = onlineDelivery;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    // displays delivery mode (read-only)
    public String displayDeliveryMode() {
        return onlineDelivery ? "Online" : "In-Person";
    }

    // clears the form
    public void clearForm() {
        this.studentName = null;
        this.emailAddress = null;
        this.courseName = null;
        this.onlineDelivery = false;
    }


}
