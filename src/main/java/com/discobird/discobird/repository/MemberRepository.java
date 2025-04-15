package com.discobird.discobird.repository;

import com.discobird.discobird.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
//    public Member save(Member member);
    public Optional<Member> findByEmail(String email);
}
