package com.green.feedextra.Feed.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class FeedRes {
    private long feedId;
    private List<String> pics;
}
