package fr.esgi.membership.member.domain;

import java.util.List;
import java.util.Optional;

public interface MemberDao {
    
    List<Member> findAll();

    Optional<Member> findById(String id);

    List<Member> findByRole(String role);

    String save(Member member);
}
