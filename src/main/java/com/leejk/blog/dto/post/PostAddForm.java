package com.leejk.blog.dto.post;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostAddForm {

    @NotNull
    private String title;

    @NotNull
    private String contents;

}
