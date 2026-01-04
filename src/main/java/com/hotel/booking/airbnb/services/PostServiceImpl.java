package com.hotel.booking.airbnb.services;

import com.hotel.booking.airbnb.dtos.PostDto;
import com.hotel.booking.airbnb.entities.PostEntity;
import com.hotel.booking.airbnb.exceptions.ResourceNotFoundException;
import com.hotel.booking.airbnb.repositories.IPostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements IPostService{

    private final IPostRepository postRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<PostDto> getAllPosts() {
        return postRepository.findAll().stream()
            .map(postEntity -> modelMapper.map(postEntity,PostDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public PostDto addPost(PostDto inputPost) {
        PostEntity entity = modelMapper.map(inputPost,PostEntity.class);
         return modelMapper.map(postRepository.save(entity),PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto inputPost, Long postId){
        PostEntity existingPost = postRepository
            .findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post not Found by Id "+postId));
     inputPost.setId(postId);
     modelMapper.map(inputPost,existingPost);
     return modelMapper.map(postRepository.save(existingPost),PostDto.class);
    }
}
