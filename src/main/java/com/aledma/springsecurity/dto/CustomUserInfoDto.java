package com.aledma.springsecurity.dto;

import com.aledma.springsecurity.domain.user.RoleType;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomUserInfoDto {

    private Long memberId;

    private String email;

    private String name;

    private String password;

    private RoleType role;
}
