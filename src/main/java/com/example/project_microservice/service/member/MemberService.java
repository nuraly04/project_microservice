package com.example.project_microservice.service.member;

import com.example.project_microservice.model.member.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    Member get(Long memberId);

    List<Member> findByIds(List<Long> memberIds);

    Optional<Member> findById(Long memberId);
}
