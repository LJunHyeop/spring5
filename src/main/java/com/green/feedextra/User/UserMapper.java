package com.green.feedextra.User;


import com.green.feedextra.User.model.insUser;
import com.green.feedextra.User.model.SignInUser;
import com.green.feedextra.User.model.User;
import com.green.feedextra.common.model.SignInRes;
import org.apache.ibatis.annotations.Mapper;

@Mapper

public interface UserMapper {
    int insUser(insUser p);


    User SignInUser(String p);
}
