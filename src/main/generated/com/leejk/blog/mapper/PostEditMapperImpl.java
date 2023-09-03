package com.leejk.blog.mapper;

import com.leejk.blog.domain.Post;
import com.leejk.blog.dto.post.PostEditForm;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-03T20:11:12+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Amazon.com Inc.)"
)
public class PostEditMapperImpl implements PostEditMapper {

    @Override
    public Post toEntity(PostEditForm dto) {
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
    public PostEditForm toDto(Post entity) {
        if ( entity == null ) {
            return null;
        }

        Integer id = null;
        String title = null;
        String contents = null;

        id = entity.getId();
        title = entity.getTitle();
        contents = entity.getContents();

        PostEditForm postEditForm = new PostEditForm( id, title, contents );

        return postEditForm;
    }
}
