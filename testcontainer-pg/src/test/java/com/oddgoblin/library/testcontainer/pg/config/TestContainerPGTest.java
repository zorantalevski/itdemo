package com.oddgoblin.library.testcontainer.pg.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.seavus.karaka.BaseIT;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestContainerPGConfig.class})
@ActiveProfiles({TestContainerPGConfig.TESTCONTAINER_PG})
public class TestContainerPGTest extends BaseIT {

    @Test
    public void testContext() {}
}
