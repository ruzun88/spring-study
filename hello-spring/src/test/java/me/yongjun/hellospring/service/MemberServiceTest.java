package me.yongjun.hellospring.service;

import me.yongjun.hellospring.domain.Member;
import me.yongjun.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();
    MemberService service = new MemberService(repository);

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("hello");
        // when
        Long savedId = service.join(member);

        // then
        Member foundMember = service.findOne(member.getId()).get();
        Assertions.assertThat(foundMember).isEqualTo(member);
    }

    @Test
    void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("hello");

        Member member2 = new Member();
        member2.setName("hello");

        // when
        service.join(member1);
//        service.join(member2);

        // then
        assertThrows(IllegalStateException.class, () -> {
            service.join(member2);
        });

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}