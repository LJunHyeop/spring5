package com.green.feedextra.Feed;


import com.green.feedextra.Feed.model.*;
import com.green.feedextra.comment.model.FeedCommentGetRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {
    int insFeedReq(FeedPostReq p);

    int postFeedPics(FeedPicPostDto p);

    List<FeedGetRes> FeedGetPost(FeedGetReq p);

    List<String> getFeedPicsByFeedId(long feedId);

    List<FeedCommentGetRes> getFeedCommentBy4ByFeedIdTo(long feedId);
}
