package com.aledma.springsecurity.domain.user;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class AuditingFields {

    @CreatedDate
    private LocalDateTime createdAt; // 생성일시

    @CreatedBy
    private String createdBy; // 생성자

    @LastModifiedDate
    private LocalDateTime modifiedAt; // 수정일시

    @LastModifiedBy
    private String modifiedBy; // 수정자
}