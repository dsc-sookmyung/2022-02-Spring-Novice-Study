package com.jojoldu.book.springboot;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//스프링 부트의 자동 설정 , 사용하는 위치 부터 설정을 읽어 가기 때문에 항상 프로젝트의 최상단에 위치해 있어야 한다.
@SpringBootApplication


//Application - 메인클래스
public class Application {
    public static void main(String[] args){
        //내장 WAS 실행 ,  별도로 외부에 WAS를 두지 않고 애플리케이션을 실행할 때 내부에서 WAS를 실행하는 것,
        // 항상 서버에 Tomcat을 설치할 필요 없고 Jar 파일로 실행하면 된다.
        SpringApplication.run(Application.class, args);
    }

}