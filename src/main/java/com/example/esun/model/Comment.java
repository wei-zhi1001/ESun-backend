package com.example.esun.model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data

@Table(name = "Comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Comment ID")
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "User ID")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "Post ID")
    private Post post;

    @Column(name = "Content")
    private String content;

    @Column(name = "Created At")
    private Date createdAt;

    // Getters and setters
}
