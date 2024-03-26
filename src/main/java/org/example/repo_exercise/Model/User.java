package org.example.repo_exercise.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name cannot be empty ")
    @Length(min = 5,message = "the name length should be more than 4")
    @Column(columnDefinition = "varchar(10) not null")// check(length>4)
    private String name ;
    @NotEmpty(message = "the username cannot be empty ")
    @Length(min = 5,message = "the username length should be more than 4")
    @Column(columnDefinition = "varchar(15) not null unique ")//check(length>4)
    private String userName;
    @NotEmpty(message = "the password cannot be empty")
    @Column(columnDefinition = "varchar(10) not null")
    private String password;
    @Email
    @NotEmpty(message = "the email cannot be empty")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;
    @NotEmpty(message = "the role cannot be empty")
    @Pattern(regexp = "(user|admin)",message = "the role should be user or admin only")
   @Column(columnDefinition = "varchar(5) not null check(role='user' or role='admin')")
    private String role;
    @NotNull(message = "the age cannot be empty")
    @Column(columnDefinition = "int not null")
    private Integer age;


}
