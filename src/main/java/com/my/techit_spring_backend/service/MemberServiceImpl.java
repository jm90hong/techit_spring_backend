package com.my.techit_spring_backend.service;


import com.my.techit_spring_backend.domain.Member;
import com.my.techit_spring_backend.domain.Product;
import com.my.techit_spring_backend.respository.MemberRepository;
import com.my.techit_spring_backend.respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member save(Member member) {
        try {
            return  memberRepository.save(
                    new Member(
                            member.getEmail(),
                            member.getMemberCode(),
                            member.getPoint()

                    )
            );
        }catch (Exception e){
            e.printStackTrace();
        }

        return  null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        try {
            Optional<Member> memberData = memberRepository.findById(id);
            if (memberData.isPresent()){
                return  memberData;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }

    @Override
    public Member update(Long id, Member member) {
        try {
            Optional<Member> memberData = memberRepository.findById(id);
            if(memberData.isPresent()){
                Member _member = memberData.get();
                _member.setPoint(memberData.get().getPoint()+1000);
                memberRepository.save(_member);
                return  _member;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void delete(Long id) {

    }


}
