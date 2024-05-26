package com.my.techit_spring_backend.service;



import com.my.techit_spring_backend.domain.Member;
import com.my.techit_spring_backend.domain.Product;

import java.util.Optional;

public interface MemberService {

    public Member save(Member member);
    public Optional<Member> findById(Long id);
    public Member update(Long id, Member member);
    public void delete(Long id);

}
