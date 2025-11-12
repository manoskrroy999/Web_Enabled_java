package DataTable;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("studentBean")
@SessionScoped
public class StudentBean implements Serializable {

    private List<Student> students = new ArrayList<>();
    private Student newStudent = new Student();

    public StudentBean() {
        // sample initial data
        students.add(new Student("101", "Kael", "AI"));
        students.add(new Student("102", "Aarav", "CSE"));
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getNewStudent() {
        return newStudent;
    }

    public void setNewStudent(Student newStudent) {
        this.newStudent = newStudent;
    }

    // Add new student to table
    public void addStudent() {
        students.add(new Student(newStudent.getId(), newStudent.getName(), newStudent.getDepartment()));
        newStudent = new Student(); // reset form
    }

    // Remove student from table
    public void deleteStudent(Student s) {
        students.remove(s);
    }
}