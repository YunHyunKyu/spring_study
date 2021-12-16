package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// @Controller가 있으면 스프링이 뜰 때 관리를 한다.
@Controller
public class MemberController {
    // 스프링 컨테이너에 등록이되고 받아서 쓸 수 있게 해야 한다.
//    private final MemberService memberService = new MemberService(); // 여러 개 쓸 필요가 없다.

    private final MemberService memberService;

    // @Autowired가 있으면 스프링 컨테이너에 있는 MemberService를 가져다가 연결을 해준다.
   @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
       return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
