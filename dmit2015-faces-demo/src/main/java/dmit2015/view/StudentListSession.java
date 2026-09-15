package dmit2015.view;

import dmit2015.model.StudentInfo;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
// @SessionScoped: the object is created for one user session.
// Every tine access, session is created and default value is 15 mins.
// Allows you to store data like a shopping card.
// Useful when you want to store and look at multiple views and datasets.
public class StudentListSession implements Serializable {

    private List<StudentInfo> studentInfos = new ArrayList<>(); // getter

    public void addStudentInfo(StudentInfo newStudentInfo) {
        studentInfos.add(newStudentInfo);
    }

    public void removeStudentInfo(StudentInfo selectedStudentInfo) {
        studentInfos.remove(selectedStudentInfo);
    }

    public List<StudentInfo> getStudentInfos() {
        return studentInfos;
    }
}
