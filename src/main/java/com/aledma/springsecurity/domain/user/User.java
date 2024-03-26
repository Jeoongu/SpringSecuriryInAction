package com.aledma.springsecurity.domain.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString(callSuper = true)
@NoArgsConstructor
@Table(name = "USERS")
@Getter
@Entity
public class User extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;            // 유저pk

    @Column(name = "login_id", nullable = false)
    private String loginId;     // 로그인 ID

    @Column(name = "password", nullable = false)
    private String password;    // 로그인 비밀번호

    @Column(name = "username", nullable = false)
    private String username;    // 유저실명

    @Column(name = "email", nullable = false)
    private String email;       // 이메일

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleType roleType;  // 계정 타입

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    @Builder
    private User(Long id, String loginId, String password, String username, String email, RoleType roleType, UserStatus userStatus) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.username = username;
        this.email = email;
        this.roleType = roleType;
        this.userStatus = userStatus;
    }
}
