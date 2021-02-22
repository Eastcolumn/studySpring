package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
    //4가지 기능, Optional<>는 검색할 때 Null이면 반환 예외처리 따로 안해줘도 되는 기능을 가진 문법
}
