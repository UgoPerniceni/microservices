package fr.esgi.membership.common;

import fr.esgi.membership.member.domain.Member;
import fr.esgi.membership.member.infra.MemberEntity;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper implements Mapper<Member, MemberEntity> {

    public Member toDomain(MemberEntity entity) {

        return new Member(entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getBirthDate(),
                entity.getCreatedAt(),
                entity.getRole()
        );
    }

    public MemberEntity toEntity(Member object) {

        return new MemberEntity(object.getId(),
                object.getFirstName(),
                object.getLastName(),
                object.getBirthDate(),
                object.getCreatedAt(),
                object.getRole()
        );
    }
}
