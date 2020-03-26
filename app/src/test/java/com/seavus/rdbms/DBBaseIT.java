package com.seavus.rdbms;

//import com.oddgoblin.library.embedded.pg.config.EmbeddedPGConfig;
import com.oddgoblin.library.testcontainer.pg.config.TestContainerPGConfig;
import com.seavus.karaka.BaseIT;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

// with jsonb
//@ContextConfiguration(classes = {EmbeddedPGConfig.class})
//@ActiveProfiles({EmbeddedPGConfig.EMBEDDED_PG})
@ContextConfiguration(classes = {TestContainerPGConfig.class})
@ActiveProfiles({TestContainerPGConfig.TESTCONTAINER_PG})
public class DBBaseIT extends BaseIT {
}
