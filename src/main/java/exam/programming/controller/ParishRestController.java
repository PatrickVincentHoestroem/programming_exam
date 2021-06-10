package exam.programming.controller;

import exam.programming.model.Commune;
import exam.programming.model.Parish;
import exam.programming.repository.CommuneRepository;
import exam.programming.repository.ParishRepository;
import exam.programming.web.ParishDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/parishes")
public class ParishRestController {

    @Autowired
    ParishRepository parishRepository;
    @Autowired
    CommuneRepository communeRepository;

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<Parish>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(parishRepository.findAll());
    }

    @PostMapping(value="/create")
    public ResponseEntity<String> create(@RequestBody @Validated ParishDto pDto) {
        Optional<Commune> commune = communeRepository.findById(pDto.getCommuneId());
        if (commune.isPresent()) {
            Parish p = parishRepository.save(new Parish(pDto, commune.get()));
            return ResponseEntity.status(HttpStatus.CREATED).body("{'msg' : 'created id' " + p.getId() + "}");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'msg' : 'commune_id " + pDto.getCommuneId() + " not found'}");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable("id") Integer id, @RequestBody Parish p) {
        Optional<Parish> optionalParish = parishRepository.findById(id);
        if (optionalParish.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'msg' : 'parish_id " + id + " not found'");
        }
        parishRepository.save(p);
        return ResponseEntity.status(HttpStatus.OK).body("{ 'msg' : 'updated' }");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        Optional<Parish> optionalParish = parishRepository.findById(id);
        if (optionalParish.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{ 'msg' : 'parish_id " + id + " not found'}");
        }

        Parish p = optionalParish.get();

        p.getCommune().remove(p);
        p.setCommune(null);

        parishRepository.save(p);
        parishRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("{ 'msg' : 'deleted'}");
    }
}
