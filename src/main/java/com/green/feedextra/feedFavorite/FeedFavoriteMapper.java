package com.green.feedextra.feedFavorite;

import com.green.feedextra.feedFavorite.model.FeedFavoriteToggleReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedFavoriteMapper {

    int toggleFavorite(FeedFavoriteToggleReq p);

    int delToggleFavorite(FeedFavoriteToggleReq p);



}
