package br.com.emanuelgabriel.microservicestudentapi.service;

import br.com.emanuelgabriel.microservicestudentapi.model.request.StudentModelInputRequest;
import br.com.emanuelgabriel.microservicestudentapi.model.response.StudentModelResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface StudentService {

    StudentModelResponse criar(StudentModelInputRequest request);
    Page<StudentModelResponse> buscarTodos(Pageable pageable);
    Optional<StudentModelResponse> buscarPorID(Long id);

}
