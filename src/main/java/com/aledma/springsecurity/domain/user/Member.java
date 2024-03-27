package com.aledma.springsecurity.domain.user;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Table(name = "MEMBER")
@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE", nullable = false)
    private RoleType role;

//    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
//    private List<Category> categories;
}
