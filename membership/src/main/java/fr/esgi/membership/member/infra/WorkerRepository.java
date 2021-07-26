package fr.esgi.membership.member.infra;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<WorkerProfileEntity, String> {
}
