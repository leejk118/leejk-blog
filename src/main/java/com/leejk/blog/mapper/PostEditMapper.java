package com.leejk.blog.mapper;

import com.leejk.blog.domain.Post;
import com.leejk.blog.dto.post.PostEditForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostEditMapper extends EntityMapper<PostEditForm, Post> {

    PostEditMapper MAPPER = Mappers.getMapper(PostEditMapper.class);

}
