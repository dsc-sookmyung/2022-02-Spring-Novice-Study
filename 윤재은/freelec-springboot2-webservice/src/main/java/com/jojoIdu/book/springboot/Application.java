//메인 클래스
package com.jojoIdu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정
public class Application { //항상 프로젝트 최상단에 위치해야함
    public static void main(String[] args){
        //내장 WAS(Web Application Server) 실행
        SpringApplication.run(Application.class, args);
    }
}
