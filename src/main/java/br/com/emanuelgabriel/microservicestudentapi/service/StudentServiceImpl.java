package br.com.emanuelgabriel.microservicestudentapi.service;

import br.com.emanuelgabriel.microservicestudentapi.model.request.StudentModelInputRequest;
import br.com.emanuelgabriel.microservicestudentapi.model.response.StudentModelResponse;
import br.com.emanuelgabriel.microservicestudentapi.persistence.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final StudentRepository studentRepository;

    @Override
    public StudentModelResponse criar(StudentModelInputRequest request) {
        LOGGER.info("Criando um resgitro de student");
        return null;
    }
}
