package fr.esgi.membership.member.domain;

import java.time.LocalDate;
import java.util.Set;

public class ClientProfile extends Profile {

    private Role role;

    private long money;

    private Set<String> projects;

    public ClientProfile(String id, String firstName, String lastName, LocalDate birthDate, LocalDate createdAt, String email, String password, Role role, long money, Set<String> projects) {
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
