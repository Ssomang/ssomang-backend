package com.example.school.Socials;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    public MemberRepo memberRepo;
    public PasswordEncoder passwordEncoder;

    public void saveItem(Integer studentno, String username, String password) {
        Member member = new Member();
        member.setStudentno(studentno);
        member.setUsername(username);
        member.setPassword(passwordEncoder.encode(password));
        memberRepo.save(member);
    }
}
