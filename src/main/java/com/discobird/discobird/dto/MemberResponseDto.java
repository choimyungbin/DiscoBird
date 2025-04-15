package com.discobird.discobird.dto;

public class MemberResponseDto {
    private String nickname;
    private String email;
    private String description;

    public MemberResponseDto(String nickname, String email, String description) {
        this.nickname = nickname;
        this.email = email;
        this.description = description;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }
}
