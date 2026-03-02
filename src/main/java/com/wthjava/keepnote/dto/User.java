package com.wthjava.keepnote.dto;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="users")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
   private int id;


@Column(unique = true, nullable = false)
    private  String username;
@Column( nullable = false)
     private String password;
}
