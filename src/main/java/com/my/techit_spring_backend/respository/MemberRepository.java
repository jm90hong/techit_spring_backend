package com.my.techit_spring_backend.respository;


import com.my.techit_spring_backend.domain.Member;
import com.my.techit_spring_backend.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    public Optional<Member> findByMemberCode(String code);

}
