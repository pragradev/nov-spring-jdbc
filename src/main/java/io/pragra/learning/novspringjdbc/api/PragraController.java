package io.pragra.learning.novspringjdbc.api;

import io.pragra.learning.novspringjdbc.dto.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/abc")
public class PragraController {

    @GetMapping("/hello")
    public String sayHello(@RequestParam("sid") String studentId,
                           @RequestParam("fn") String firstName,
                           @RequestParam("ln") String lastName){
        Student student = new Student(studentId,firstName,lastName);
        System.out.println(student);
        return "Hello " + firstName + " From Pragra";
    }

    @GetMapping("/nice/{fn}/{ln}")
    public String sayNice(@PathVariable("fn") String firstName,@PathVariable("ln") String lastName){
        return "A Nice Hello From " + firstName + " " + lastName;
    }

    @GetMapping("/student")
    public Student getStudent(){
        Student student = new Student("1", "Karan", "B");
        return student;
    }

    @PostMapping("/print")
    public void printStudent(@RequestBody Student student){
        System.out.println(student);
    }


}
