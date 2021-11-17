package io.zbqmgldjfh.coronavirustracker.security;

import io.zbqmgldjfh.coronavirustracker.models.Member;
import io.zbqmgldjfh.coronavirustracker.persistence.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Autowired
    public SecurityUserDetailsService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Optional<Member> optional = memberRepository.findById(Long.parseLong(userId));
        if(!optional.isPresent()){
            throw new UsernameNotFoundException(userId + "사용자 없음");
        }else{
            Member member = optional.get();
            return new SecurityUser(member);
        }

    }
}
