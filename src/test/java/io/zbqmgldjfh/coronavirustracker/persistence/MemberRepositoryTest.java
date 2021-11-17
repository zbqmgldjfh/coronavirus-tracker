package io.zbqmgldjfh.coronavirustracker.persistence;

import io.zbqmgldjfh.coronavirustracker.models.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    public void testInsert(){
        Member member1 = new Member();
        member1.setEmail("test@naver.com");
        member1.setPassword("1234");
        member1.setName("test");
        member1.setEnabled(true);
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setEmail("test2@naver.com");
        member2.setPassword("1111");
        member2.setName("test2");
        member2.setEnabled(true);
        memberRepository.save(member2);

        Assertions.assertThat(memberRepository.findById(1L).equals(member1));
        Assertions.assertThat(memberRepository.findById(2L).equals(member2));
    }
}
