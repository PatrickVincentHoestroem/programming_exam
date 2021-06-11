package exam.programming.controller;

import exam.programming.model.Commune;
import exam.programming.repository.CommuneRepository;
import exam.programming.repository.ParishRepository;
import exam.programming.web.CommuneDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/commune")
public class CommuneRestController {

    @Autowired
    CommuneRepository communeRepository;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody CommuneDto communeDto) {
        Commune c = new Commune(communeDto);
        communeRepository.save(c);
        return ResponseEntity.status(HttpStatus.CREATED).body("{'msg' : 'created id' " + c.getId() + "}");
    }
}
