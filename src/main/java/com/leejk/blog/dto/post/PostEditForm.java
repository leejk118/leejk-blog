package com.leejk.blog.dto.post;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostEditForm {

    @NotNull
    private Integer id;

    @NotNull
    private String title;

    @NotNull
    private String contents;

}
