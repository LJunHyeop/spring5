package com.green.feedextra.comment;


import com.green.feedextra.comment.model.FeedCommentDeleteReq;
import com.green.feedextra.comment.model.FeedCommentGetRes;
import com.green.feedextra.comment.model.FeedCommentPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class FeedCommentService {
    private final FeedCommentMapper mapper;

    public long postFeedComment(FeedCommentPostReq p){
        int affectedRows = mapper.postFeedComment(p);
        return p.getFeedCommentId();
    }
    public int FeedCommentDeleteReq(FeedCommentDeleteReq p){
        return mapper.FeedCommentDeleteReq(p);
    }
     public List<FeedCommentGetRes> getFeedComment(long boardId){
        return mapper.getFeedComment(boardId);
     }
}

