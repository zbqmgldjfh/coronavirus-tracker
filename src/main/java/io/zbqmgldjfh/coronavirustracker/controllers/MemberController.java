package io.zbqmgldjfh.coronavirustracker.controllers;

import io.zbqmgldjfh.coronavirustracker.models.Member;
import io.zbqmgldjfh.coronavirustracker.models.Role;
import io.zbqmgldjfh.coronavirustracker.models.SignUpForm;
import io.zbqmgldjfh.coronavirustracker.persistence.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/add")
    public String addForm(@ModelAttribute("form") SignUpForm form){
        return "members/addMemberForm";
    }

    @PostMapping("/add")
    public String save(@Validated @ModelAttribute("form") SignUpForm form, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "members/addMemberForm";
        }

        if(!form.getPassword().equals(form.getConfirmpassword())){
            bindingResult.rejectValue("confirmpassword", "notMatchPassword", "비밀번호가 다릅니다.");
            return "members/addMemberForm";
        }

        Member member = new Member();
        member.setEmail(form.getEmail());
        member.setPassword(form.getPassword());
        member.setName(form.getName());
        member.setRole(Role.ROLE_MEMBER);
        member.setEnabled(true);

        log.info("member = {}", member);
        memberRepository.save(member);
        return "redirect:/";
    }
}
