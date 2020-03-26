package com.oddgoblin.library.embedded.pg.config;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import com.seavus.karaka.BaseIT;

@ContextConfiguration(classes = {EmbeddedPGConfig.class})
@ActiveProfiles({EmbeddedPGConfig.EMBEDDED_PG})
public class EmbeddedPGConfigIT extends BaseIT {

    @Test
    public void testContext() {}
}
