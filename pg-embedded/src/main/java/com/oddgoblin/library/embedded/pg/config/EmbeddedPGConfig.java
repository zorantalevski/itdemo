package com.oddgoblin.library.embedded.pg.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;

@Profile(EmbeddedPGConfig.EMBEDDED_PG)
@Configuration
@PropertySource("classpath:/application-embedded-pg.yml")
public class EmbeddedPGConfig {

    public static final String EMBEDDED_PG = "embedded-pg";

    @Value("${spring.datasource.port}")
    Integer dbPort;

    @Bean("dataSource")
    DataSource getDataSource(EmbeddedPostgres embeddedPostgres) {
        return embeddedPostgres.getPostgresDatabase();
    }

    @Bean
    EmbeddedPostgres getEmbeddedPostgres() throws IOException {
        return EmbeddedPostgres.builder().setPort(dbPort).start();
    }
}
