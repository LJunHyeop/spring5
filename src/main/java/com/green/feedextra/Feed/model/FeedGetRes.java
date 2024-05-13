package com.green.feedextra.Feed.model;

import com.green.feedextra.comment.model.FeedCommentGetRes;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class FeedGetRes {
    private long feedId;
    private List<String> pics;
    private long writerId;
    private String writerNm;
    private String writerPic;
    private String contents;
    private String location;
    private String createdAt;

    private int isFav;
    private int isMoreComment;

    private List<FeedCommentGetRes> comments;


}
