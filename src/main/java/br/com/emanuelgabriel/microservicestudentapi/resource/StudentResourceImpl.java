package br.com.emanuelgabriel.microservicestudentapi.resource;

import br.com.emanuelgabriel.microservicestudentapi.model.request.StudentModelInputRequest;
import br.com.emanuelgabriel.microservicestudentapi.model.response.StudentModelResponse;
import br.com.emanuelgabriel.microservicestudentapi.service.StudentService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class StudentResourceImpl {


    private static final Logger LOGGER = LoggerFactory.getLogger(StudentResourceImpl.class);

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<Page<StudentModelResponse>> buscarTodos(Pageable pageable){
        LOGGER.info("GET /students - todos os students");
        Page<StudentModelResponse> studentResponse = this.studentService.buscarTodos(pageable);
        return studentResponse != null ? ResponseEntity.ok(studentResponse) : ResponseEntity.ok().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<StudentModelResponse> criar(@Valid @RequestBody StudentModelInputRequest request){
        LOGGER.info("POST /students {}", request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idStudent}").buildAndExpand(request.getName()).toUri();
        return ResponseEntity.created(location).body(this.studentService.criar(request));
    }

}
