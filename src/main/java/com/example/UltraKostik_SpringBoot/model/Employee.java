package com.example.UltraKostik_SpringBoot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "ФИО не должно быть пустым")
    @Column(nullable = false)
    private String fullName;

    @Email(message = "Некорректный формат электронной почты")
    @NotBlank(message = "Почта не должна быть пустой")
    @Column(nullable = false)
    private String email;
    
    @Pattern(regexp = "^(\\+7|8)?\\d{10}$")
    @NotBlank(message = "Телефон не должен быть пустым")
    @Column(nullable = false)
    private String phone;

    @NotBlank(message = "Позиция не должна быть пустой")
    @Column(nullable = false)
    private String position;

    @DecimalMin(value = "0.01", message = "Зарплата должна быть больше 0")
    @NotNull(message = "Зарплата не должна быть пустой")
    @Column(nullable = false)
    private Double salary;

    @Column(nullable = false)
    private Boolean active = true;

}
