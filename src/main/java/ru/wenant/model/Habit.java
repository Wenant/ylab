package ru.wenant.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Habit {

    private String name;
    private String description;
    private int frequencyInDays;
    private LocalDate creationDate;
    private LocalDate lastTrackedDate;
    private Map<LocalDate, Boolean> completionRecords = new HashMap<>();
    private int currentStreak;


}
