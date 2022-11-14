package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.domain.Student;
import com.nhnacademy.springmvc.exception.StudentNotFoundException;
import com.nhnacademy.springmvc.repository.StudentRepository;
import lombok.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @ModelAttribute("student")
    public Student getPost(@PathVariable("studentId") long studentId) {
        return studentRepository.getStudent(studentId);
    }

    @GetMapping("/{studentId}")
    public String viewStudent(@Validated @ModelAttribute("student") Student student,
                              ModelMap modelMap) {
        if (Objects.isNull(student)) {
            modelMap.put("exception", new StudentNotFoundException());
            return "error";
        }

        modelMap.put("student", student);
        return "studentView";
    }

    @GetMapping("/{studentId}?hideScore=yes")
    public String hideViewStudent(@ModelAttribute("student") Student student,
                                  ModelMap modelMap){
        modelMap.put("student", student);
        return "hideStudentView";
    }

    @GetMapping("/{studentId}/modify")
    public String studentModifyForm(@Validated @ModelAttribute("student") Student student,
                                    Model model) {
        if (Objects.isNull(student)) {
            model.addAttribute("exception", new StudentNotFoundException());
            return "error";
        }

        model.addAttribute("student", student);
        return "studentModify";
    }

    @PostMapping("/{studentId}/modify")
    public ModelAndView modifyUser(@ModelAttribute("student") Student student) {

        ModelAndView mav = new ModelAndView("studentView");
        mav.addObject("student", student);
        return mav;
    }
}
