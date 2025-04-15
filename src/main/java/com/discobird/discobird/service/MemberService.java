package com.discobird.discobird.service;

import com.discobird.discobird.domain.Member;
import com.discobird.discobird.dto.MemberResponseDto;
import com.discobird.discobird.repository.MemberRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    private MemberRepository repository;
    private BCryptPasswordEncoder passwordEncoder;
    public MemberService(MemberRepository repository, BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }
    /**
     * Save the new member
     * @param member the member to save
     * @return the saved member
     */
    public Member join(Member member) {
        String hashedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(hashedPassword);
        return repository.save(member);
    }

    /**
     * Save the post
     * @param email the email address of the member to retrieve
     * @return an Optional containing the member if found, or empty if not
     */
    public Optional<Member> getMemberByEmail(String email) {
        return repository.findByEmail(email);
    }

    public MemberResponseDto toDto(Member member) {
        return new MemberResponseDto(member.getNickname(), member.getEmail(), member.getDescription());
    }

}
