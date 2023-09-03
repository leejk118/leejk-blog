package com.leejk.blog.dto.comment;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CommentAddForm {

    @NotNull
    private String writer;

    @NotNull
    private String password;

    @NotNull
    private String comments;
}
