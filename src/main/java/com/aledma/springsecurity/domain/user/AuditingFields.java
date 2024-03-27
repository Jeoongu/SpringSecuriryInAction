package com.aledma.springsecurity.domain.user;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/*
@EntityListners(AuditingEntityListner.class): Entity를 DB에 적용하기 이전과 이후에 커스텀 콜백을 요청할 수 있게 한다.
(해당 클래스에 Auditing 기능을 포함시킨다)
@MappedSuperclass: Entity에서 공통된 필드를 사용할 때 Base Entity에 정의한 다음 상속받는 형식으로 중복을 줄이기 위해 사용한다.
 */
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class AuditingFields {

    @CreatedDate // Entity 생성 시간 자동 저장
    private LocalDateTime createdAt; // 생성일시

    @CreatedBy // Entity 생성자 자동 저장
    private String createdBy; // 생성자

    @LastModifiedDate // Entity 값 수정한 시간 자동 저장
    private LocalDateTime modifiedAt; // 수정일시

    @LastModifiedBy // Entity 수정자 자동 저장
    private String modifiedBy; // 수정자
}