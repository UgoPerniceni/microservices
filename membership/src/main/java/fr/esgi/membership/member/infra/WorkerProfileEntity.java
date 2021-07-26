package fr.esgi.membership.member.infra;

import fr.esgi.membership.member.domain.Role;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "worker")
@DiscriminatorValue("WORKER")
public class WorkerProfileEntity extends ProfileEntity {

    @Enumerated(value = EnumType.STRING)
    @Column(insertable = false, updatable = false)
    private Role role;

    private String project;

    private long dailyPrice;

    @ElementCollection
    private Set<String> skills;

    public WorkerProfileEntity() {
    }

    public WorkerProfileEntity(String id, String firstName, String lastName, LocalDate birthDate, LocalDate createdAt, String email, String password, Role role, String project, long dailyPrice, Set<String> skills) {
        super(id, firstName, lastName, birthDate, createdAt, email, password);
        this.role = role;
        this.project = project;
        this.dailyPrice = dailyPrice;
        this.skills = skills;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public long getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(long dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }
}
