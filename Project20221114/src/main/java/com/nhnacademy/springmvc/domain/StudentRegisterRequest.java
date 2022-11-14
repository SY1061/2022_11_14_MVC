package com.nhnacademy.springmvc.domain;

import lombok.Value;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Value
public class StudentRegisterRequest {
    @NotBlank
    String name;
    @Email
    String email;
    @Size(min = 0, max = 100)
    int score;
    @NotBlank
    @Length(min = 0, max = 200)
    String comment;
}
