package com.example.school.Socials;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final MemberRepo memberRepo;
    private final MyUserDetailsService myUserDetailsService;

    @PostMapping("/login")
    public String login(@RequestParam("studentno") Integer studentno, @RequestParam("password") String password) {
        Optional<Member> member = memberRepo.findByStudentNoAndPassword(studentno, password);
        if (member.isPresent()) {
            Member foundMember = member.get();
            var userDetails = myUserDetailsService.loadUserByUsername(foundMember.getUsername());
            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return "redirect:/timetable";
        } else {
            return "redirect:/login?error=true";
        }
    }

    @PostMapping("/register")
    public String register(Integer studentno, String username, String password) {
        memberService.saveItem(studentno, username, password);
        return "redirect:/timetable";
    }
}