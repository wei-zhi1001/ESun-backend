package com.example.esun.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User ID")
    private Long userId;

    @Column(name = "User Name")
    private String userName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "Cover Image")
    private String coverImage;

    @Column(name = "Biography")
    private String biography;


}
