package com.leejk.blog.mapper;

import com.leejk.blog.domain.Post;
import com.leejk.blog.dto.post.PostAddForm;
import com.leejk.blog.dto.post.PostEditForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostAddMapper extends EntityMapper<PostAddForm, Post> {

    PostAddMapper MAPPER = Mappers.getMapper(PostAddMapper.class);

}
