package fr.esgi.membership.member.infra;

import fr.esgi.membership.member.domain.Role;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "client")
@DiscriminatorValue("CLIENT")
public class ClientProfileEntity extends ProfileEntity {

    @Enumerated(value = EnumType.STRING)
    @Column(insertable = false, updatable = false)
    private Role role;

    private long money;

    @ElementCollection
    private Set<String> projects;

    public ClientProfileEntity() {
    }

    public ClientProfileEntity(String id, String firstName, String lastName, LocalDate birthDate, LocalDate createdAt, String email, String password, Role role, long money, Set<String> projects) {
        super(id, firstName, lastName, birthDate, createdAt, email, password);
        this.role = role;
        this.money = money;
        this.projects = projects;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public Set<String> getProjects() {
        return projects;
    }

    public void setProjects(Set<String> projects) {
        this.projects = projects;
    }
}
