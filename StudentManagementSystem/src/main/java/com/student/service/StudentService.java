package com.student.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.student.entity.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Add student
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    //  Get all students
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
    
//  Get student by ID
    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }
    
//  Update student by ID
    public Student updateStudent(int id, Student student) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));

        existing.setName(student.getName());
        existing.setAge(student.getAge());
        existing.setAddress(student.getAddress()); // ✅ fixed spelling

        return studentRepository.save(existing);
    }

    //  Delete student by ID
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    

    
}
