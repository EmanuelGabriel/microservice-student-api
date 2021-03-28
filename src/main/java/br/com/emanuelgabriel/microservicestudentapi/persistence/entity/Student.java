package br.com.emanuelgabriel.microservicestudentapi.persistence.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.function.Function;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "student_sequence",
            strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    /**
     * Pegar um objeto de referência e mapear para um objeto do tipo 'Cliente'
     * @param function
     * @param <R>
     * @return
     */
    public <R> R map(Function<Student, R> function){
        return function.apply(this);
    }

}
