package com.example.esun.model;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss EE")
    @Column(name = "Created At")
    private Date createdAt;

}
