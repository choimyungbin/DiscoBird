package com.discobird.discobird.service;

import com.discobird.discobird.domain.Member;
import com.discobird.discobird.dto.MemberResponseDto;
import com.discobird.discobird.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MemberServiceTest {

    private MemberRepository memberRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private MemberService memberService;

    @BeforeEach
    void setUp() {
        memberRepository = mock(MemberRepository.class);
        passwordEncoder = mock(BCryptPasswordEncoder.class);
        memberService = new MemberService(memberRepository, passwordEncoder);
    }

    @Test
    void testJoin_shouldHashPasswordAndSave() {
        Member member = new Member();
        member.setEmail("test@example.com");
        member.setPassword("plaintext");

        // Stubbing
        when(passwordEncoder.encode("plaintext")).thenReturn("hashed_pw");
        when(memberRepository.save(any(Member.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Member savedMember = memberService.join(member);

        assertEquals("hashed_pw", savedMember.getPassword());
        verify(passwordEncoder).encode("plaintext");
        verify(memberRepository).save(member);
    }

    @Test
    void testGetMemberByEmail_shouldReturnOptionalMember() {
        Member member = new Member();
        member.setEmail("user@example.com");
        when(memberRepository.findByEmail("user@example.com")).thenReturn(Optional.of(member));

        Optional<Member> result = memberService.getMemberByEmail("user@example.com");

        assertTrue(result.isPresent());
        assertEquals("user@example.com", result.get().getEmail());
        verify(memberRepository).findByEmail("user@example.com");
    }

    @Test
    void testToDto_shouldConvertMemberToDto() {
        Member member = new Member();
        member.setNickname("nick");
        member.setEmail("nick@example.com");
        member.setDescription("test desc");

        MemberResponseDto dto = memberService.toDto(member);

        assertEquals("nick", dto.getNickname());
        assertEquals("nick@example.com", dto.getEmail());
        assertEquals("test desc", dto.getDescription());
    }
}
