package com.my.techit_spring_backend.controller;

import com.my.techit_spring_backend.domain.Member;
import com.my.techit_spring_backend.domain.Product;
import com.my.techit_spring_backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/member")
public class MemberCotroller {


    @Autowired
    MemberService memberService;


    @PostMapping("create")
    public ResponseEntity<Product> create(@RequestBody Member member) {
        try {
            ResponseEntity.status(HttpStatus.CREATED).body(memberService.save(member));
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

}
