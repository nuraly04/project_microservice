package com.example.project_microservice.service.member.impl;

import com.example.project_microservice.exception.DataNotFoundException;
import com.example.project_microservice.model.member.Member;
import com.example.project_microservice.repository.member.MemberRepository;
import com.example.project_microservice.service.member.MemberService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MemberServiceImpl implements MemberService {

    MemberRepository memberRepository;

    @Override
    @Transactional
    public Member get(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(
                        () -> new DataNotFoundException("Мембер не найден")
                );
    }

    @Override
    @Transactional
    public List<Member> findByIds(List<Long> memberIds) {
        return memberRepository.findAllByIdIn(memberIds);
    }

    @Override
    @Transactional
    public Optional<Member> findById(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
