package com.leejk.blog.mapper;

import com.leejk.blog.domain.Post;
import com.leejk.blog.dto.post.PostAddForm;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-03T20:11:10+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Amazon.com Inc.)"
)
public class PostAddMapperImpl implements PostAddMapper {

    @Override
    public Post toEntity(PostAddForm dto) {
        if ( dto == null ) {
            return null;
        }

        String title = null;
        String contents = null;

        title = dto.getTitle();
        contents = dto.getContents();

        Post post = new Post( title, contents );

        return post;
    }

    @Override
    public PostAddForm toDto(Post entity) {
        if ( entity == null ) {
            return null;
        }

        String title = null;
        String contents = null;

        title = entity.getTitle();
        contents = entity.getContents();

        PostAddForm postAddForm = new PostAddForm( title, contents );

        return postAddForm;
    }
}
