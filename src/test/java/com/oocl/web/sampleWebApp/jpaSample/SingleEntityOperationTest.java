package com.oocl.web.sampleWebApp.jpaSample;

import com.oocl.web.sampleWebApp.SingleEntity;
import com.oocl.web.sampleWebApp.SingleEntityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SingleEntityOperationTest {
    @Autowired
    private SingleEntityRepository singleEntityRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void should_fetch_entity(){
        final SingleEntity singleEntity = new SingleEntity();
        singleEntity.id = 1L;
        singleEntity.name = "Hi";
        singleEntityRepository.save(singleEntity);

        final SingleEntity fetch = singleEntityRepository.getOne(1L);

        assertEquals("Hi", fetch.name);
    }

    @Test
    public void should_not_store_to_database_if_length_exceed(){
        final SingleEntity singleEntity = new SingleEntity();

    }
}
