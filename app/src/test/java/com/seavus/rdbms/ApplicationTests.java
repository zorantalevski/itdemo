package com.seavus.rdbms;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;


@RunWith(SpringJUnit4ClassRunner.class)
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:dao/TestData.sql")
public class ApplicationTests extends DBBaseIT {


    @Autowired
    private EventLogRepository eEventLogRepository;

    @Test
    public void testContext() {
        Assert.assertTrue(eEventLogRepository.findEventLogByType("Training") != null);
    }

    @Test
    @Transactional
    public void simpleEntity() {

        eEventLogRepository.save(EventLog.builder()
                .id(new Random().nextInt())
                .type("Presentation")
                .status("IN_PROGRESS")
                .build());

        Assert.assertTrue(eEventLogRepository.findEventLogByType("Presentation") != null);
    }

//    with json b
    @Test
    @Transactional
    public void entityWithJsonFieldType() {

        String json = "{\"type\": \"Presentation\", \"events\": [\"Test Containers Demo\"], \"status\": \"Presentation\"}";

        eEventLogRepository.save(EventLog.builder()
                .id(new Random().nextInt())
                .type("Presentation")
                .status("IN_PROGRESS")
                .rawJson(json)
                .build());

        Assert.assertTrue(eEventLogRepository.findEventLogByType("TestName") != null);
    }
}
