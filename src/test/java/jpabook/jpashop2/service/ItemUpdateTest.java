package jpabook.jpashop2.service;

import jpabook.jpashop2.domain.item.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

@SpringBootTest
public class ItemUpdateTest {

    @Autowired EntityManager em;

    @Test
    public void updateTest() {
        Book book = em.find(Book.class, 1L);

        // tx
        book.setName("asfdsafasdf");

        // 변경감지 == dirty checking
        // tx commit

    }

}
