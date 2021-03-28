package br.com.emanuelgabriel.microservicestudentapi.model.response;

import br.com.emanuelgabriel.microservicestudentapi.persistence.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentModelResponse {

    private Long id;
    private String name;
    private String email;
    private Gender gender;



}

