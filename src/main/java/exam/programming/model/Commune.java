package exam.programming.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import exam.programming.web.CommuneDto;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Commune {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "commune", cascade = CascadeType.ALL)
    private Set<Parish> parishes;

    public Commune() {}

    public Commune(CommuneDto communeDto) {
        this.name = communeDto.getName();
    }

    public Commune(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void add(Parish parish) {
        parishes.add(parish);
    }

    public void remove(Parish parish) {
        parishes.remove(parish);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @JsonIgnore
    public Set<Parish> getParishes() {
        return parishes;
    }

    public void resetParishes() {
        parishes = new HashSet<Parish>();
    }
}
