package jpabook.jpashop2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Jpashop2Application {

    public static void main(String[] args) {

        Hello hello = new Hello();
        hello.setData("Hello");
        String data = hello.getData();

        SpringApplication.run(Jpashop2Application.class, args);
    }

}
