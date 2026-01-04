package com.hotel.booking.airbnb.services;


import com.hotel.booking.airbnb.dtos.PostDto;

import java.util.List;

public interface IPostService {

    List<PostDto> getAllPosts();

    PostDto addPost(PostDto inputPost);

    PostDto updatePost(PostDto inputPost, Long postId);


}
