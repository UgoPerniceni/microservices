package fr.esgi.market.projects.domain;

import java.time.LocalDate;
import java.util.List;

public class Project {

    private String id;

    private LocalDate start;

    private LocalDate end;

    private List<String> skills;

    public Project(String id, LocalDate start, LocalDate end, List<String> skills) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.skills = skills;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}
