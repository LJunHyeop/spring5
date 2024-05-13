package com.green.feedextra.feedFavorite;


import com.green.feedextra.Feed.model.FeedGetRes;
import com.green.feedextra.common.ResultDto;
import com.green.feedextra.feedFavorite.model.FeedFavoriteToggleReq;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/feed/favorite")
@RestController



public class FeedFavoriteController {
    private final FeedFavoriteService service;


    // 전송데이터 적음, 데이터 노출되어도 되는 것 . post 대신 get 사용 가능  데이터 노출 되도 되거나  전송데이터 적으면 get 사용 가능
    @GetMapping
   public ResultDto<Integer> toggleFavorite(@ModelAttribute FeedFavoriteToggleReq p) {
       int result = service.delToggleFavorite(p);
       return ResultDto.<Integer>builder()
               .statusCode(HttpStatus.OK)
               .resultMsg(HttpStatus.OK.toString())
               .resultData(result).build();
   }

}

