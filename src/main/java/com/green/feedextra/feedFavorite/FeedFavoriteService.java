package com.green.feedextra.feedFavorite;


import com.green.feedextra.feedFavorite.model.FeedFavoriteToggleReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FeedFavoriteService {

    private final FeedFavoriteMapper mapper;


    public  int  toggleFavorite(FeedFavoriteToggleReq p){
        return mapper.toggleFavorite(p);
    }

    public int delToggleFavorite(FeedFavoriteToggleReq p){
        int result = mapper.delToggleFavorite(p);
        if(result == 1){
            return 0;
        }
        return mapper.toggleFavorite(p);

        //select 로 레코드 있는지 확인
        //레코드 있으면 delete return 0
        //레코드 없으면 insert return 1

        //방법론(2)
        // insert 에러 > delete

        //방법론(3)
        // delete 1 > return 0;
        // delete 0 > insert return 1;

    }


}
