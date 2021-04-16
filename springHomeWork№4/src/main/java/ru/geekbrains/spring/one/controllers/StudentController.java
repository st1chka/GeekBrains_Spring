package ru.geekbrains.spring.one.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.one.model.Student;
import ru.geekbrains.spring.one.services.StudentService;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // [http://localhost:8189/app]/
    @GetMapping("/")
    public String showAllStudentsPage(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "index";
    }

    @GetMapping("/students/{id}")
    public String showStudentInfo(@PathVariable(name = "id") Long id, Model model) {
        Optional<Student> student = studentService.findOneById(id);
        if (student.isPresent()) {
            model.addAttribute("student", student.get());
        }
        return "student_info";
    }

    // [http://localhost:8189/app]/students/creator
    @GetMapping("/students/create")
    public String showCreator() {
        return "create_student_form";
    }


    @GetMapping("/students/search")
    public String showSearch() {
        return "search_student";
    }


    @PostMapping("/students/{id}")
    public String searchStudent(@RequestParam(defaultValue = "0") Long id, Model model) {
        Optional<Student> student = studentService.findOneById(id);
        if (student.isPresent()) {
            model.addAttribute("student", student.get());
        }
        return "student_info";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudentById(@PathVariable Long id) {
        studentService.deleteById(id);
        return "redirect:/";
    }
    @GetMapping("/students/plus/{id}")
    public String plusStudentScore(@PathVariable Long id) {
        studentService.plusScore(id);
        return "redirect:/";
    }
    @GetMapping("/students/minus/{id}")
    public String minusStudentScore(@PathVariable Long id) {
        studentService.minusScore(id);
        return "redirect:/";
    }
}

//    [http://localhost:8189/app]/students/create?id=10&name=Nicolas&score=95
//    @PostMapping("/create")
//    public String createNewStudent(@RequestParam Long id, @RequestParam String name, @RequestParam int score) {
//        Student student = new Student(id, name, score);
//        studentService.save(student);
//        return "redirect:/students/all";
//    }

    // POST [http://localhost:8189/app]/students/create
    // body: id=10&name=Nicolas&score=95
    // public class Student {
    //    private Long id;
    //    private String name;
    //    private int score;

    // Student student = new Student();
    // requestparam: id=10
    // student.set[Id](10);
    // requestparam: name=10
    // student.set[Name](Nicolas);
    // requestparam: score=95
    // student.set[Score](95);

