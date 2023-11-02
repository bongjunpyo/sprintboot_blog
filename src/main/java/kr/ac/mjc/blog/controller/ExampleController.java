package kr.ac.mjc.blog.controller;

import kr.ac.mjc.blog.dto.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.model.IAttribute;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ExampleController {
    @GetMapping("/example")
    public String example(Model model){
        Person examplePerson = new Person();
        examplePerson.setId(2l);
        examplePerson.setName("봉준표");
        examplePerson.setAge(21);
        examplePerson.setHobbies(List.of("운동", "독서"));

        model.addAttribute("person",examplePerson);
        model.addAttribute("Today", LocalDate.now());

        return "example";
    }
}
