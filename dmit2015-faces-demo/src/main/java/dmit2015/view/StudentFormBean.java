package dmit2015.view;

import dmit2015.model.StudentInfo;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ViewScoped
public class StudentFormBean implements Serializable {

    // Field-level injection for simplicity (constructor injection is preferred)
    @Inject
    private StudentListSession studentListSession;



    private int submissionCount; // getter

    private StudentInfo studentInfo = new StudentInfo(); // getter
    // -> composition (object within an object)

    public void submit() {
        studentListSession.addStudentInfo(studentInfo); // container will create it; access gained to method

        submissionCount++;
        FacesMessage message = new FacesMessage(
                FacesMessage.SEVERITY_INFO,
                "Form Submitted",
                "Welcome " + studentInfo.getFullName()
                        + " from " + studentInfo.getProgram()
        );
        FacesContext.getCurrentInstance()
                .addMessage(null, message);

        // clear the form fields by assigning a new model
        studentInfo = new StudentInfo();
        // two-way data binding -> when you want to clear and add in new inputs for the fields,
        // the whole form resets.

    }

    public int getSubmissionCount() {
        return submissionCount;
    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }
}
