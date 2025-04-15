package com.discobird.discobird.controller;

import com.discobird.discobird.domain.Member;
import com.discobird.discobird.dto.MemberResponseDto;
import com.discobird.discobird.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/join")
    public Member join(@RequestBody Member member){
        return memberService.join(member);
    }

    @GetMapping
    public Optional<MemberResponseDto> getMemberByEmail(@RequestParam String email) {
        return memberService.getMemberByEmail(email)
                .map(m -> new MemberResponseDto(m.getNickname(), m.getEmail(), m.getDescription()));
    }
}
