package com.green.feedextra.comment;



import com.green.feedextra.comment.model.FeedCommentDeleteReq;
import com.green.feedextra.comment.model.FeedCommentGetRes;
import com.green.feedextra.comment.model.FeedCommentPostReq;
import com.green.feedextra.common.ResultDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/feed/comment")
public class FeedCommentController {
    private  final FeedCommentService service;

    @PostMapping
    public ResultDto<Long> postFeedComment(@RequestBody FeedCommentPostReq p){
        long result =service.postFeedComment(p);
        return ResultDto.<Long>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg(HttpStatus.OK.toString())
                .resultData(result).build();
    }
    @DeleteMapping
    public ResultDto<Integer> FeedCommentDeleteReq(@ParameterObject @ModelAttribute  FeedCommentDeleteReq p){
        int result = service.FeedCommentDeleteReq(p);

        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg(HttpStatus.OK.toString())
                .resultData(result).build();

    }
    @GetMapping
    public ResultDto<List<FeedCommentGetRes>> getFeedComment (@RequestParam(name = "feed_id") Long feedId){
        List<FeedCommentGetRes> res = service.getFeedComment(feedId);
        return ResultDto.<List<FeedCommentGetRes>>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg(HttpStatus.OK.toString())
                .resultData(res).build();
    }
}
