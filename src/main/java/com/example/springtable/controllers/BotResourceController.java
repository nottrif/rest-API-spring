package com.example.springtable.controllers;

import com.example.springtable.repository.BotRepository;
import com.example.springtable.schema.Bot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
// versioning the API is a good practice to avoid breaking changes in the future (e.g. /api/v2)
public class BotResourceController {

    //    @Autowired - this is dependency injection (DI) - Spring will automatically create an instance of the BotRepository and inject it here
    @Autowired
    private BotRepository botRepository;

    @GetMapping("/bots")
    public ResponseEntity<List<Bot>> getBots(@RequestParam(required = false) String name) {
        if (name == null) {
            return ResponseEntity.ok(botRepository.findAll());
        } else {
            return ResponseEntity.ok(botRepository.findBybotName(name));
        }
    }

    @PostMapping("/bots")
    public Bot createBot(@RequestBody Bot bot) {
        return botRepository.save(bot);
    }

    @PutMapping("/bots/{id}")
    public ResponseEntity updateBot(@PathVariable String id) {
        Bot bot = botRepository.findByBotId(id);
        if (bot == null) {
            return ResponseEntity.badRequest().body("ID does not exist");
        }
        
    }
}

