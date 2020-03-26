package com.oddgoblin.library.testcontainer.pg.config;

import static java.lang.String.format;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.testcontainers.containers.PostgreSQLContainer;


@Profile(TestContainerPGConfig.TESTCONTAINER_PG)
@Configuration
@PropertySource("classpath:/application-testcontainer-pg.yml")
public class TestContainerPGConfig {

    public static final String TESTCONTAINER_PG = "testcontainer-pg";

    @Value("${spring.datasource.dbName}")
    String dbName;

    @Value("${spring.datasource.username}")
    String dbUsername;

    @Value("${spring.datasource.password}")
    String dbPassword;

    @Value("${spring.datasource.driverClassName}")
    String driverClassName;

    @Bean("dataSource")
    public DataSource dataSource(PostgreSQLContainer postgreSQLContainer) throws SQLException {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(driverClassName);
        ds.setUrl(format("jdbc:postgresql://%s:%s/%s", postgreSQLContainer.getContainerIpAddress(),
                postgreSQLContainer.getMappedPort(PostgreSQLContainer.POSTGRESQL_PORT),
                postgreSQLContainer.getDatabaseName()));
        ds.setUsername(postgreSQLContainer.getUsername());
        ds.setPassword(postgreSQLContainer.getPassword());
        return ds;
    }

    @Bean
    public PostgreSQLContainer getPostgreSQLContainer() {
        PostgreSQLContainer postgres = (PostgreSQLContainer) new PostgreSQLContainer("postgres:10.3").withDatabaseName(
                dbName).withUsername(dbUsername).withPassword(dbPassword);
        postgres.start();
        return postgres;
    }
}
