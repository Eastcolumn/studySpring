package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store= new HashMap<>();
    //실무에서는 동시성 문제가 있어서 공유되는 변수있을 떄는 Conquerer HashMap을 써야한다.
    private static long sequence =0L;
    //실무에서는 어텀 롱 써야!..


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }
//Null일때를 위해 Optional.ofNullable로 감싸기
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
        //자바의 람다
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }


    public void clearStore(){
        store.clear();
    }
}
