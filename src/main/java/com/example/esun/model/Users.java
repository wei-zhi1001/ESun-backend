package com.example.esun.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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

    @Column(name = "Phone")
    private String phone;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> post;
}
