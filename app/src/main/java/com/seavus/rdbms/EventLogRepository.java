package com.seavus.rdbms;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Zoran.Talevski
 * main eventlog repository
 */
@Repository
@Transactional
public interface EventLogRepository extends CrudRepository<EventLog, Long> {

    Optional<EventLog> findEventLogByType(String type);
}
