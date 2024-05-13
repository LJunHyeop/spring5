package com.green.feedextra.Feed.model;

import com.green.feedextra.common.GlobalConst;
import com.green.feedextra.common.model.Paging;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.BindParam;

@Getter
@Setter
public class FeedGetReq extends Paging {
    @Schema(name = "signed_user_id")
    private Long signedUserId;

    public FeedGetReq(Integer page, Integer size,
                      @BindParam("signed_user_id")
                      Long signedUserId) {
        super(page , size== null || size == 0 ? GlobalConst.FEED_PAGE_ITEM_LEN : size);
        this.signedUserId = signedUserId;
    }

//    public void setPage(int page) {
//        this.page = page;
//        this.size = FEED_PAGE_ITEM_LEN;
//        this.startIdx = (this.page - 1) * this.size;
//    }
}
