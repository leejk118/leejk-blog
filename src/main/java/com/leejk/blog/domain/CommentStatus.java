package com.leejk.blog.domain;

import lombok.Getter;

@Getter
public enum CommentStatus {
    EXPOSED("노출"),

    HIDDEN("비노출"),

    DELETED("삭제");

    private final String description;

    CommentStatus(String description) {
        this.description = description;
    }

}
