package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
  //      AppConfig appConfig = new AppConfig();
  //      MemberService memberService = appConfig.memberService();
       // MemberService memberService = new MemberServiceImpl();

        /*
        * ApplicationContext : 스프링 컨테이너, 인터페이스(-> 다형성 적용)
        * @Bean 이라 적힌 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록.
        * */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new findMember = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
