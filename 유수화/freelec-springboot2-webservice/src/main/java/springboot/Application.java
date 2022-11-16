package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication //스프링 부트의 자동설정, 스프링 Bean 읽기와 생성 모두 자동 설정. 특히 @~~ 이 있는 위치부터 설정을 읽기에 이 클래스는 플젝 최상단에 있어야함

public class Application { //앞으로 만들 프로젝트의 메인 클래스
    public static void main(String[] args){

        SpringApplication.run(Application.class , args);
    }
}
