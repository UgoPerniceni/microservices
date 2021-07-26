package fr.esgi.membership.member.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradesmanRepository extends JpaRepository<TradesmanProfileEntity, String> {
}
