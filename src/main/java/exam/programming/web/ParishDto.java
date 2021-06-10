package exam.programming.web;

public class ParishDto {
    private String name;
    private int communeId;
    private int infectionPressure;
    private String contaminationStart;

    public ParishDto(String name, int communeId, int infectionPressure, String contaminationStart) {
        this.name = name;
        this.communeId = communeId;
        this.infectionPressure = infectionPressure;
        this.contaminationStart = contaminationStart;
    }

    public ParishDto() {}

    public String getName() {
        return name;
    }

    public int getCommuneId() {
        return communeId;
    }

    public int getInfectionPressure() {
        return infectionPressure;
    }

    public String getContaminationStart() {
        return contaminationStart;
    }
}
