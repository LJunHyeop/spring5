package com.green.feedextra.User.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class insUser {
    private String uid;
    private String upw;
    private String nm;
    private String pic;
    @JsonIgnore
    private long userId;
}
