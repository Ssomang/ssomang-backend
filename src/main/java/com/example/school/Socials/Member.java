package com.example.school.Socials;

import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
@Setter
@Getter
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public Integer studentno;
    public String username;
    public String password;
}