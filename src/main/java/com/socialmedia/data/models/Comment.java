package com.socialmedia.data.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue
    private UUID id;

    private String commentatorName;
    private LocalDate datePublished;

    @Column(nullable = false, length = 150)
    private String content;


    public Comment(String commentatorName, String content) {
        this.content = content;
        this.commentatorName = commentatorName;
    }
}
