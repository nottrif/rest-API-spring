package com.example.springtable.repository;

import com.example.springtable.schema.Bot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BotRepository extends JpaRepository<Bot, Long> {
    List<Bot> findBybotName(String botName); // custom finder method which returns a list of bots of the given name

    Bot findByBotId(String botId);

    // no need to implement any methods, it is already implemented in JpaRepository
    // and plugged in by Spring Data JPA

}
