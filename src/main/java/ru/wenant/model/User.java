package ru.wenant.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {

    private String name;
    private String email;
    private String password;
}
