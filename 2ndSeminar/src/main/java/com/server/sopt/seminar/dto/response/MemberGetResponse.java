package com.server.sopt.seminar.dto.response;

import com.server.sopt.seminar.domain.Member;
import com.server.sopt.seminar.domain.Sopt;

public record MemberGetResponse(
        String name,
        String nickname,
        int age,
        Sopt soptInfo
) {
    public static MemberGetResponse of(Member member) {
        return new MemberGetResponse(
                member.getName(),
                member.getNickname(),
                member.getAge(),
                member.getSopt()
        );
    }
}