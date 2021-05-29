package com.socialmedia.service.post;

import com.socialmedia.data.models.Comment;
import com.socialmedia.data.models.Post;
import com.socialmedia.data.repository.PostRepository;
import com.socialmedia.web.dtos.PostDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
@Service
@Slf4j

public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Override
    public Post savePost(PostDto postDto) {
        Post post = new Post();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(postDto, post);

        return postRepository.save(post);
    }

    @Override
    public List<Post> findAllPosts() {
        List<Post> allPosts = postRepository.findAll();
        return allPosts;
    }

    @Override
    public Post updatePost(PostDto postDto) {
        return null;
    }

    @Override
    public Post findPostById(Integer id) {
        return null;
    }

    @Override
    public void deletePostById(Integer id) {

    }

    @Override
    public Post addCommentToPost(Integer id, Comment comment) {
        return null;
    }
}
