package com.nhnacademy.springmvc.validator;

import com.nhnacademy.springmvc.domain.StudentRegisterRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class StudentRegisterRequestValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return StudentRegisterRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "404", "name is empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "404", "email is empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "score", "404", "score is empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"comment", "404", "comment is empty");

        StudentRegisterRequest request = (StudentRegisterRequest) target;
        int score = request.getScore();
        if (score > 100){
            errors.rejectValue("score", "404", "score max is 100");
        }

        String comment = request.getComment();
        if (comment.length() > 100) {
            errors.rejectValue("comment", "404", "content max length is 200");
        }
    }
}
