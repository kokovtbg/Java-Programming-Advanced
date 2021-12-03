package Exams.Exam14April2021.university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (this.students.size() < this.capacity) {
            if (!this.students.contains(student)) {
                this.students.add(student);
                return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
            } else {
                return "Student is already in the university";
            }
        } else {
            return "No seats in the university";
        }
    }

    public String dismissStudent(Student student) {
        if (this.students.contains(student)) {
            String studentRemoved = "Removed student ";
            for (int i = 0; i < this.students.size(); i++) {
                if (this.students.get(i).equals(student)) {
                    studentRemoved += this.students.get(i).getFirstName() + " " + this.students.get(i).getLastName();
                }
            }
            this.students.remove(student);
            return studentRemoved;
        } else {
            return "Student not found";
        }
    }

    public Student getStudent(String firstName, String lastName) {
        for (int i = 0; i < this.students.size(); i++) {
            if (this.students.get(i).getFirstName().equals(firstName) && this.students.get(i).getLastName().equals(lastName)) {
                return this.students.get(i);
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        for (int i = 0; i < this.students.size(); i++) {
            if (i < this.students.size() - 1) {
                statistics.append("==Student: First Name = ").append(this.students.get(i).getFirstName()).append(", Last Name = ").append(this.students.get(i).getLastName()).append(", Best Subject = ").append(this.students.get(i).getBestSubject()).append("\n");
            } else {
                statistics.append("==Student: First Name = ").append(this.students.get(i).getFirstName()).append(", Last Name = ").append(this.students.get(i).getLastName()).append(", Best Subject = ").append(this.students.get(i).getBestSubject());
            }
        }
        return statistics.toString();
    }

}
