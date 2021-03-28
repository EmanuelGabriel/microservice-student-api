package br.com.emanuelgabriel.microservicestudentapi.service;

import br.com.emanuelgabriel.microservicestudentapi.model.request.StudentModelInputRequest;
import br.com.emanuelgabriel.microservicestudentapi.model.response.StudentModelResponse;
import br.com.emanuelgabriel.microservicestudentapi.persistence.entity.Student;
import br.com.emanuelgabriel.microservicestudentapi.persistence.repository.StudentRepository;
import br.com.emanuelgabriel.microservicestudentapi.service.mapper.Mapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final StudentRepository studentRepository;
    private final Mapper<StudentModelInputRequest, Student> requestStudentMapper;
    private final Mapper<Student, StudentModelResponse> studentModelResponseMapper;

    @Override
    public StudentModelResponse criar(StudentModelInputRequest request) {
        LOGGER.info("Criando um resgitro de student");
        Assert.notNull(request, "Request inválida");
        Student student = this.requestStudentMapper.map(request);
        return this.studentRepository.saveAndFlush(student).map((Student input) -> this.studentModelResponseMapper.map(input));
    }

    @Override
    public Page<StudentModelResponse> buscarTodos(Pageable pageable) {
        LOGGER.info("Buscar todos os students");
        Assert.notNull(pageable, "Página inválida");
        return this.studentRepository.findAll(pageable).map(student -> this.studentModelResponseMapper.map(student));
    }
}
