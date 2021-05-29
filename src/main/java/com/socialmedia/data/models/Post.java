package com.socialmedia.data.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Author author;

    @Column(nullable = false, unique = true, length = 60)
    private String title;
    private String postContent;
    private LocalDate datePublished;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> comments;

    public void addComment(Comment...comment){
        if (comments==null){
            comments= new ArrayList<>();
        }
        this.comments.addAll(Arrays.asList(comment));
    }

}
