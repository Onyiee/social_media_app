package com.socialmedia.data.repository;


import com.socialmedia.data.models.Author;
import com.socialmedia.data.models.Comment;
import com.socialmedia.data.models.Post;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Slf4j
@Sql(scripts = {"classpath:db/insert.sql"})


public class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void postCanBeCreatedAndSaved(){
     Post post = new Post();
     post.setTitle("The Importance of Tech Skills in The 21st Century");
     post.setPostContent("Donec mattis lacus lectus, condimentum pulvinar orci tincidunt dignissim." +
             " Donec metus odio, congue sed nulla posuere, sodales dignissim nisl. ");
     log.info("Created a post-->{}", post);
     postRepository.save(post);
     assertThat(post.getId()).isNotNull();
    }

    @Test
    void addAuthorToPost(){
        Post post = new Post();
        post.setTitle("The Importance of Tech Skills in The 21st Century");
        post.setPostContent("Donec mattis lacus lectus, condimentum pulvinar orci tincidunt dignissim." +
                " Donec metus odio, congue sed nulla posuere, sodales dignissim nisl. ");
        log.info("Created a post --> {}",post);
        Author author = new Author();
        author.setUserName("OneBlackGirl");
        author.setEmail("theBlackOne@mail.com");
        author.setPhoneNumber("0709456780");

        //map relationships
        post.setAuthor(author);
        author.addPosts(post);
        postRepository.save(post);
        log.info("post after after saving -->  {}", post);
    }

    @Test
    void findAllPosts(){
        List<Post> allPosts = postRepository.findAll();
        assertThat(allPosts).isNotNull();
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void deletePost(){
        Post postToDelete = postRepository.findById(10).orElse(null);
        assertThat(postToDelete).isNotNull();
        log.info("Fetched post from database-->{}", postToDelete);

        postRepository.delete(postToDelete);

        Post deletedPost = postRepository.findById(10).orElse(null);
        assertThat(deletedPost).isNull();
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void updateSavedPost(){
       Post foundPost = postRepository.findById(11).orElse(null);
       assertThat(foundPost).isNotNull();
       log.info("fetched post from database-->{}", foundPost);

       foundPost.setTitle("Girls and software engineering");
       postRepository.save(foundPost);
       Post updatedPost = postRepository.findById(11).orElse(null);

       assertThat(updatedPost).isNotNull();
       assertThat(updatedPost.getTitle()).isEqualTo("Girls and software engineering");

    }

    @Test
    @Transactional
    @Rollback(value = false)
    void updatePostAuthor(){
        Post postToUpdate = postRepository.findById(11).orElse(null);
        assertThat(postToUpdate).isNotNull();
        assertThat(postToUpdate.getTitle()).isNotNull();
        log.info("Fetched post to update it's author-->{}", postToUpdate);

        //Create new
        Author author = new Author();
        author.setUserName("Smartie");
        author.setEmail("smartGirl@mail.com");
        author.setPhoneNumber("081673456");

        postToUpdate.setAuthor(author);
        postRepository.save(postToUpdate);

        Post updatedPost = postRepository.findById(11).orElse(null);

        assertThat(updatedPost).isNotNull();
        assertThat(updatedPost.getAuthor()).isNotNull();
        assertThat(updatedPost.getAuthor().getUserName()).isEqualTo("Smartie");

    }

    @Test
    @Transactional
    @Rollback(value = false)
    void addCommentToPost(){
       Post postToAddComment = postRepository.findById(11).orElse(null);
       assertThat(postToAddComment).isNotNull();
       assertThat(postToAddComment.getComments()).hasSize(0);

       //Create comments
        Comment firstComment = new Comment("Peniel","Tech is the way to go");
        Comment secondComment = new Comment("Valerie","More girls should be taught to innovate using tech");
        Comment thirdComment = new Comment("Walter", "Tech makes the world go round");
        log.info("comment --> {}", firstComment);
        postToAddComment.addComment(firstComment, secondComment, thirdComment);

        postRepository.save(postToAddComment);

        Post commentedPost = postRepository.findById(11).orElse(null);
        assertThat(commentedPost).isNotNull();
        assertThat(commentedPost.getComments()).hasSize(3);
        log.info("Commented on post-->{}", commentedPost);
    }
}
