package com.socialmedia.service.post;

import com.socialmedia.data.models.Comment;
import com.socialmedia.data.models.Post;
import com.socialmedia.web.dtos.PostDto;

import java.util.List;

public interface PostService {
    Post savePost (PostDto postDto);
    List<Post> findAllPosts();
    Post updatePost(PostDto postDto);
    Post findPostById (Integer id);
    void deletePostById (Integer id);
    Post addCommentToPost (Integer id, Comment comment);


}
