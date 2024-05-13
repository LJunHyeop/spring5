package com.green.feedextra.comment;


import com.green.feedextra.comment.model.FeedCommentDeleteReq;
import com.green.feedextra.comment.model.FeedCommentGetRes;
import com.green.feedextra.comment.model.FeedCommentPostReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

public interface FeedCommentMapper {
    int postFeedComment(FeedCommentPostReq p);

    int FeedCommentDeleteReq(FeedCommentDeleteReq p);

    List<FeedCommentGetRes> getFeedComment(long boardId);

}
