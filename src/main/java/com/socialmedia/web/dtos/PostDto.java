package com.socialmedia.web.dtos;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PostDto {
    private String title;
    private String content;
    private MultipartFile imageFile;
}
