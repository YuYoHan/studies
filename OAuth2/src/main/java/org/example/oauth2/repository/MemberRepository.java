package org.example.oauth2.repository;

import org.example.oauth2.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    MemberEntity findByUserName(String userName);
}
