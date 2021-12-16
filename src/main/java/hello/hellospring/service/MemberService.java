package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// 서비스의 용도는 비즈니스 의존적으로 설계
// 리포지토리 같은 경우는 그저 데이터 빼, 넣어 이런 용도
// class에 가져다 되고 ctrl + shift + t 누르면 테스트 코드 만들어짐.


//@Service
public class MemberService {
    private final MemberRepository memberRepository;

    // 외부에서 넣어주도록 바꿔준다,, DI라고 한다.
    //    @Autowired
    public MemberService(MemberRepository memberRepository)  {
        this.memberRepository = memberRepository;
    }
    
    // 회원가입
    public Long join(Member member) {

        // 함수로 만들고 싶으면 만들고 싶은 범위를 감싸고 ctrl + alt + m
        validateDuplicateMember(member); // 중복 회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // 같은 이름이 있는 중복 회원은 X
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });

        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw  new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 아이디를 통한 조회
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
