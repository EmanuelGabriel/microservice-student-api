package br.com.emanuelgabriel.microservicestudentapi.persistence.repository;

import br.com.emanuelgabriel.microservicestudentapi.persistence.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
