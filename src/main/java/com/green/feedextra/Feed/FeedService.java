package com.green.feedextra.Feed;

import com.green.feedextra.Feed.model.*;
import com.green.feedextra.comment.model.FeedCommentGetRes;
import com.green.feedextra.common.CustomFileUtils;
import com.green.feedextra.common.GlobalConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FeedService {
    private final FeedMapper mapper;
    private final CustomFileUtils customFileUtils;

    public FeedRes FeedPostReq(List<MultipartFile> pics , FeedPostReq p ) {
        int result = mapper.insFeedReq(p);

        FeedPicPostDto feedPicPostDto = FeedPicPostDto.builder().feedId(p.getFeedId()).build();
        try {
            String path = String.format("feed/%d",p.getFeedId());
            customFileUtils.makeFolders(path);
            for (MultipartFile pic : pics) {
                String saveFileName = customFileUtils.makeRandomFileName(pic);
                feedPicPostDto.getFileNames().add(saveFileName);
                String target = String.format("%s/%s",path,saveFileName);
                customFileUtils.transferTo(pic,target);
            }

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Feed 등록 오류");
        }
        int affectedRowsPics = mapper.postFeedPics(feedPicPostDto);
        return FeedRes.builder()
                .feedId(p.getFeedId())
                .pics(feedPicPostDto.getFileNames()).build();
    }

    public  List<FeedGetRes> FeedPostReq(FeedGetReq p){
        List<FeedGetRes> list = mapper.FeedGetPost(p);
        if(list == null){
            return Collections.emptyList();
        }
        for (FeedGetRes res : list) {
            List<String> pics =  mapper.getFeedPicsByFeedId(res.getFeedId());
            res.setPics(pics);
            List<FeedCommentGetRes> com = mapper.getFeedCommentBy4ByFeedIdTo(res.getFeedId());
            if(com.size() == GlobalConst.COMMENT_SIZE_PER_FEED){
                res.setIsMoreComment(1);
                com.remove(com.size()-1);
            }
           res.setComments(com);
        }
        return list;
    }
}
