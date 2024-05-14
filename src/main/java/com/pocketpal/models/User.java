package com.pocketpal.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name ="password")
    private String password;

    @Column(name ="email")
    private String email;

    @Column(name = "photo")
    private String photoUrl;

    @Column(name ="joined_data", updatable = false)
    private LocalDateTime joinedData;

    @Column(name = "isAdmin")
    private boolean isAdmin;

    @ManyToOne
    @Column(name = "status_id")
    private Status status;



}
