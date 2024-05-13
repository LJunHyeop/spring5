package com.green.feedextra.Feed;


import com.green.feedextra.Feed.model.FeedGetReq;
import com.green.feedextra.Feed.model.FeedGetRes;
import com.green.feedextra.Feed.model.FeedPostReq;
import com.green.feedextra.Feed.model.FeedRes;
import com.green.feedextra.common.ResultDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.transform.Result;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/feed")
@Slf4j
@RestController
public class FeedController {
    private final FeedService service;
    @PostMapping
    @Operation(summary = "게시글 등록")
    public ResultDto<FeedRes> FeedPostReq(@RequestPart List<MultipartFile> pics, @RequestPart FeedPostReq p) {
        FeedRes res = service.FeedPostReq(pics, p);
        return ResultDto.<FeedRes>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("게시들 등록 완료")
                .resultData(res).build();
    }

    @GetMapping
    @Operation (summary = "Feed 리스트 ",description = "loginUserId 는 로그인한 사용자의 PK ")
    public ResultDto<List<FeedGetRes>> FeedPostReq(@ParameterObject  @ModelAttribute FeedGetReq p) {
        List<FeedGetRes> result = service.FeedPostReq(p);

        return ResultDto.<List<FeedGetRes>>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg(HttpStatus.OK.toString())
                .resultData(result).build();
    }

}
