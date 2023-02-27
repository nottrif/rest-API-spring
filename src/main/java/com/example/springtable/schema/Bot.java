package com.example.springtable.schema;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// this is my data model and how i control this data model is given in controllers
@Entity
@Table(name = "bot_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bot {
    @Id
    private String botId;

    private String botName;

    private String botDesc;

    public Bot(Bot other) { //copy constructor to copy the values from one object to another
        this.botId = other.botId;
        this.botName = other.botName;
        this.botDesc = other.botDesc;
    }
}
