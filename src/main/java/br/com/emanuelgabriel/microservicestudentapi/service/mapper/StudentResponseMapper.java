package br.com.emanuelgabriel.microservicestudentapi.service.mapper;

import br.com.emanuelgabriel.microservicestudentapi.model.response.StudentModelResponse;
import br.com.emanuelgabriel.microservicestudentapi.persistence.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentResponseMapper implements Mapper<Student, StudentModelResponse>{


    @Override
    public StudentModelResponse map(Student input) {
        if (input == null){
            return null;
        }

        StudentModelResponse studentModelResponse = new StudentModelResponse();
        studentModelResponse.setId(input.getId());
        studentModelResponse.setName(input.getName());
        studentModelResponse.setEmail(input.getEmail());
        studentModelResponse.setGender(input.getGender());
        return studentModelResponse;
    }
}
