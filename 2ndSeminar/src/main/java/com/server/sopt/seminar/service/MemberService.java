package com.server.sopt.seminar.service;

import com.server.sopt.seminar.domain.Member;
import com.server.sopt.seminar.domain.Sopt;
import com.server.sopt.seminar.dto.request.MemberCreateRequest;
import com.server.sopt.seminar.dto.request.MemberProfileUpdateRequest;
import com.server.sopt.seminar.dto.response.MemberGetResponse;
import com.server.sopt.seminar.repository.MemberJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberJpaRepository memberJpaRepository;

    // public 위에 private 하단에 배치
    public MemberGetResponse getByIdV1(Long memberId) {
        Member member = memberJpaRepository.findById(memberId).get();
        MemberGetResponse response = MemberGetResponse.of(member);
        return response;
    }

    public MemberGetResponse getByIdV2(Long memberId) {
        Member member = memberJpaRepository.findById(memberId)
                .orElseThrow( () -> new EntityNotFoundException("해당하는 회원이 없습니다."));
        return MemberGetResponse.of(member);
    }

    public MemberGetResponse getByIdV2_2(Long memberId) {
        return MemberGetResponse.of(findById(memberId));
    }

    public List<MemberGetResponse> getMembers() {
        return memberJpaRepository.findAll()
                .stream()
                .map(MemberGetResponse::of)
                .collect(Collectors.toList());
    }

    @Transactional // 메소드 위에 붙인게 우선적으로 적용됨
    public String create(MemberCreateRequest request) {
        Member member =  memberJpaRepository.save(Member.builder()
                .name(request.getName())
                .nickname(request.getNickname())
                .age(request.getAge())
                .sopt(request.getSopt())
                .build());
        return member.getId().toString();
    }

    @Transactional
    public void updateSOPT(Long memberId, MemberProfileUpdateRequest request) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        member.updateSOPT(new Sopt(request.getGeneration(), request.getPart()));
    }

    @Transactional
    public void deleteMember(Long memberId) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        memberJpaRepository.delete(member);
    }

    private Member findById(Long memberId) {
        return memberJpaRepository.findById(memberId)
                .orElseThrow( () -> new EntityNotFoundException("해당하는 회원이 없습니다."));
    }
}
