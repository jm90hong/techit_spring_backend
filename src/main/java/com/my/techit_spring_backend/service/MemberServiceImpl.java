package com.my.techit_spring_backend.service;


import com.my.techit_spring_backend.domain.Member;
import com.my.techit_spring_backend.respository.MemberRepository;
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
                            member.getMemberCode(),
                            member.getEmail(),
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
                memberRepository.save(member);
                return  member;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public Optional<Member> findByMemberCode(String memberCode) {

        try{
            Optional<Member> memberData = memberRepository.findByMemberCode(memberCode);
            if (memberData.isPresent()){
                return  memberData;
            }
            return memberData;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        memberRepository.deleteById(id);
    }



}
