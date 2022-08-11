package com.example.handlerexceptionmonstarlab.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Table(name = "tbl_user_exception")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotEmpty(message = "username không được bỏ trống")
    @Size(min=4, message = "Độ dài username phải lớn hơn 4 kí tự")
    private String username;

    @Email(message = "{REGEX.VALIDATE.EMAIL}") // REGEX.VALIDATE.EMAIL in application.properties
    @NotEmpty(message = "Email không để trống")
    @Column(unique = true)
    private String email;

    @Past(message = "Ngày sinh phải là quá khứ")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
}
