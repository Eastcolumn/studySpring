package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class MemberService {


    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
    중복회원 조회
    */
    public void validateDuplicateMember(Member member){
        memberRepository.findByName(member.getName())
                .ifPresent(member1 ->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
    회원가입
    */
    public Long join(Member member){
        //중복 회원 막아야함
        validateDuplicateMember(member);//중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMember(){
        
    }
}
