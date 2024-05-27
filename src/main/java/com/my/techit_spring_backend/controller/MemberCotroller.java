package com.my.techit_spring_backend.controller;

import com.my.techit_spring_backend.domain.Member;
import com.my.techit_spring_backend.domain.Product;
import com.my.techit_spring_backend.service.MemberService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/member")
public class MemberCotroller {


    @Autowired
    MemberService memberService;


    @GetMapping("{code}")
    public Optional<Member> findByCode(@PathVariable(value="code") String code){

        try {
            Optional<Member> memberData = memberService.findByMemberCode(code);
            if(memberData.isPresent()){
                return memberData;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return  null;

    }

    @PostMapping("create")
    public ResponseEntity<Product> create(
                        @RequestBody Member member,
                        @RequestParam(value="recm_code",defaultValue = "") String recommendCode
                    ) {
        try {
            String code = RandomStringUtils.randomAlphanumeric(10);
            member.setMemberCode(code);

            //todo 회원 가입
            Member result = memberService.save(member);

            //todo 추천된 회원 포인트 증가
            Optional<Member> op = memberService.findByMemberCode(recommendCode);
            if(op.isPresent()){
                Member _m = op.get();
                op.get().setPoint(_m.getPoint()+1000);
                memberService.update(_m.getId(), _m);
            }

            ResponseEntity.status(HttpStatus.CREATED).body(result);

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

}
