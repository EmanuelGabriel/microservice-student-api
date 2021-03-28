package br.com.emanuelgabriel.microservicestudentapi.service.mapper;

import br.com.emanuelgabriel.microservicestudentapi.model.request.StudentModelInputRequest;
import br.com.emanuelgabriel.microservicestudentapi.persistence.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentRequestMapper implements Mapper<StudentModelInputRequest, Student> {

    @Override
    public Student map(StudentModelInputRequest input) {
        if (input == null){
            return null;
        }

        Student student = new Student();
        student.setName(input.getName());
        student.setEmail(input.getEmail());
        student.setGender(input.getGender());
        return student;
    }
}
