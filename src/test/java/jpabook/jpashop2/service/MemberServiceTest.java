package jpabook.jpashop2.service;

import jpabook.jpashop2.domain.Member;
import jpabook.jpashop2.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Test
    public void 회원가입() throws Exception {
        // given
        Member member = new Member();
        member.setName("kim");

        // when
        Long savedId = memberService.join(member);

        // then
        em.flush();
        assertThat(member).isEqualTo(memberRepository.findOne(savedId));

    }

    @Test
    @DisplayName("중복회원예외")
    void test() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("kim1");

        Member member2 = new Member();
        member2.setName("kim1");
        // when

        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> {
            memberService.join(member2);
        }); // 예외가 발생해야한다.
    }
}