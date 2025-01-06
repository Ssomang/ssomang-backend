package com.example.school.Socials;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MemberRepo extends JpaRepository<Member, Long> {
    Optional<Member> findByUsername(String username);
    Optional<Member> findByStudentNoAndPassword(Integer studentno, String password);
}
