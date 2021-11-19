package io.zbqmgldjfh.coronavirustracker.security;

import io.zbqmgldjfh.coronavirustracker.models.Member;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class SecurityUser extends User {
    private static final long serialVersionUID = 1L;
    private Member member;

    public SecurityUser(Member member){
        super(member.getEmail(), "{noop}" + member.getPassword(),
                AuthorityUtils.createAuthorityList(member.getRole().toString()));

        System.out.println("hello!");
    }

    public Member getMember(){
        return member;
    }
}
