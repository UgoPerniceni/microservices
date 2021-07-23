package fr.esgi.membership.member.infra;

import fr.esgi.membership.common.MemberMapper;
import fr.esgi.membership.member.domain.Member;
import fr.esgi.membership.member.domain.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MemberEntityDao implements MemberDao {

    private final MemberRepository repository;
    private final MemberMapper mapper;

    @Autowired
    public MemberEntityDao(MemberRepository repository, MemberMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Member> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    public Optional<Member> findById(String id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    
    public List<Member> findByRole(String role) {
        return repository.findAllByRole(role).stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    public String save(Member member) {
        MemberEntity memberEntity = mapper.toEntity(member);
        repository.save(memberEntity);
        return memberEntity.getId();
    }
}
