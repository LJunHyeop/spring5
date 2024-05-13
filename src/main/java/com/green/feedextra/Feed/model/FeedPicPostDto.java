package com.green.feedextra.Feed.model;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class FeedPicPostDto {
    private long feedId;
    @Builder.Default
    private List<String> fileNames = new ArrayList<>();
}

/*
foreach feedMapper 에 있음 item collection 해석문
INSERT INTO feed_pics
(feed_id,pic)
VALUES
(10,'a.jpg')
,(10,'b.jpg')
,(10,'c.jpg')

 <foreach item="item" collection="filenames" open ="(" separator=",),
        (" close =")" >
            ( #{feedId},#{item} )
        </foreach>

 */
