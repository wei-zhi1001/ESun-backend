package com.example.esun.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "Post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Post ID")
    private Long postId;

    @ManyToOne
    @JoinColumn(name = "User ID")
    private Users user;

    @Column(name = "Content")
    private String content;

    @Column(name = "Image")
    private String image;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss EE")
    @Column(name = "Created At")
    private Date createdAt;

    @OneToMany(mappedBy = "post")
    @JsonIgnore
    private List<Comment> comments;
}
