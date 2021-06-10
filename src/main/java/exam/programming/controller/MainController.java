package exam.programming.controller;

import exam.programming.model.Parish;
import exam.programming.repository.ParishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    ParishRepository parishRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Parish> l = (List<Parish>) parishRepository.findAll();
        model.addAttribute("parishes", l);
        return "index";
    }
}
