package com.my.techit_spring_backend.domain;

import jakarta.persistence.*;

@Entity
@Table(name="members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="member_code")
    private  String memberCode;

    @Column(name="email")
    private  String email;


    @Column(name="point")
    private  int point;


    public Member(){}



    public Member(String memberCode, String email, int point){
        this.memberCode=memberCode;
        this.email=email;
        this.point=point;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
