package fr.esgi.membership.member.usecase;

import fr.esgi.membership.member.domain.Member;
import fr.esgi.membership.member.domain.MemberDao;
import org.springframework.stereotype.Service;

@Service
public class AddMember {

    private final MemberDao memberDao;

    public AddMember(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public String execute(Member member) {
        return memberDao.save(member);
    }
}
