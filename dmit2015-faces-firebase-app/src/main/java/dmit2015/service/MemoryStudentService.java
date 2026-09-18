package dmit2015.service;

import dmit2015.model.Student;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Named("memoryStudentService ")
@ApplicationScoped
public class MemoryStudentService implements StudentService{

    private List<Student> students = new ArrayList<>();

    @Override
    public Student createStudent(Student student) {
        students.add(student);
        return null;
    }

    @Override
    public Optional<Student> getStudentById(String id) {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public Student updateStudent(Student student) {
        return student;
    }

    @Override
    public void deleteStudentById(String id) {
        Optional<Student> maybeStudent = getStudentById(id);
        // maybeStudent.ifPresent(students.remove(maybeStudent));
        if (maybeStudent.isPresent()) {
            Student existingStudent = maybeStudent.orElseThrow();
            students.remove(existingStudent);
        }
    }
}
