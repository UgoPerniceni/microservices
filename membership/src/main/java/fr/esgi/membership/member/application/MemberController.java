package fr.esgi.membership.member.application;

import fr.esgi.membership.member.domain.Member;
import fr.esgi.membership.member.usecase.AddMember;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final AddMember addMember;

    public MemberController(AddMember addMember) {
        this.addMember = addMember;
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Member member) {
        String id = addMember.execute(member);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }
}
