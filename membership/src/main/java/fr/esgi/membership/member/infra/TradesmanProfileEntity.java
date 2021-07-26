package fr.esgi.membership.member.infra;

import fr.esgi.membership.member.domain.Role;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "tradesman")
@DiscriminatorValue("TRADESMAN")
public class TradesmanProfileEntity extends ProfileEntity {

    @ElementCollection
    Set<String> projects;

    @Enumerated(value = EnumType.STRING)
    @Column(insertable = false, updatable = false)
    private Role role;

    public TradesmanProfileEntity() {}

    public TradesmanProfileEntity(String id, String firstName, String lastName, LocalDate birthDate, LocalDate createdAt, String email, String password, Role role, Set<String> projects) {
        super(id, firstName, lastName, birthDate, createdAt, email, password);
        this.role = role;
        this.projects = projects;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<String> getProjects() {
        return projects;
    }

    public void setProjects(Set<String> projects) {
        this.projects = projects;
    }
}
