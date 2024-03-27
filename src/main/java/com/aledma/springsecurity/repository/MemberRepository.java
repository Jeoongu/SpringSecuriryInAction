package com.aledma.springsecurity.repository;

import com.aledma.springsecurity.domain.user.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findMembersByEmail(String email);
}
