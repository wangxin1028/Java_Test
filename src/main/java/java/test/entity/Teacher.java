package java.test.entity;

import java.util.List;

public class Teacher extends Persion{
    private double salary;
    private List<Student> students;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
