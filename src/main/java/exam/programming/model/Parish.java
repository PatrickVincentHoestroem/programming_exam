package exam.programming.model;

import exam.programming.web.ParishDto;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public class Parish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    private Commune commune;
    private int infectionGrowth;
    private LocalDate contaminationStart;

    public Parish() {}

    public Parish(ParishDto p, LocalDate date, Commune commune) {
        this.name = p.getName();
        this.commune = commune;
        this.infectionGrowth = p.getInfectionPressure();
        this.contaminationStart = date;
    }

    public Parish(int id, String name, Commune commune, int infectionGrowth, LocalDate contaminationStart) {
        this.id = id;
        this.name = name;
        this.commune = commune;
        this.infectionGrowth = infectionGrowth;
        this.contaminationStart = contaminationStart;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }

    public int getInfectionGrowth() {
        return infectionGrowth;
    }

    public LocalDate getContaminationStart() {
        return contaminationStart;
    }

}
