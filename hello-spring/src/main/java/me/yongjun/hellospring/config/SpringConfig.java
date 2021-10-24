package me.yongjun.hellospring.config;

import me.yongjun.hellospring.repository.MemberRepository;
import me.yongjun.hellospring.repository.MemoryMemberRepository;
import me.yongjun.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
