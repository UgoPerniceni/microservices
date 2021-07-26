package fr.esgi.membership.member.domain;

import java.time.LocalDate;
import java.util.Set;

public class TradesmanProfile extends Profile {

    private Role role;

    private Set<String> projects;

    public TradesmanProfile(String id, String firstName, String lastName, LocalDate birthDate, LocalDate createdAt, String email, String password, Role role, Set<String> projects) {
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
