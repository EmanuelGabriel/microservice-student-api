package br.com.emanuelgabriel.microservicestudentapi.service;

import br.com.emanuelgabriel.microservicestudentapi.model.request.StudentModelInputRequest;
import br.com.emanuelgabriel.microservicestudentapi.model.response.StudentModelResponse;

public interface StudentService {

    StudentModelResponse criar(StudentModelInputRequest request);

}
