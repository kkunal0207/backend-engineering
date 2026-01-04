package com.hotel.booking.airbnb.controllers;


import com.hotel.booking.airbnb.dtos.PostDto;
import com.hotel.booking.airbnb.services.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/posts")
@RequiredArgsConstructor
public class PostController {

    private final IPostService postService;

    @GetMapping
    public List<PostDto> getAllPosts(){
        return postService.getAllPosts();
    }

    @PostMapping(path = "/addPosts")
    public PostDto addPost(@RequestBody PostDto inputPost){
        return postService.addPost(inputPost);
    }

    @PutMapping("{postId}")
    public PostDto updatePost(@RequestBody PostDto inputPost, @PathVariable Long postId){
        return postService.updatePost(inputPost,postId);
    }
}
