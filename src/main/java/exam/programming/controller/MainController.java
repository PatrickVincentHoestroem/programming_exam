package exam.programming.controller;

import exam.programming.repository.ParishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    ParishRepository parishRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
