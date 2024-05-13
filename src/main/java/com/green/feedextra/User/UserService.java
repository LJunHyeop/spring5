package com.green.feedextra.User;


import com.green.feedextra.User.model.insUser;
import com.green.feedextra.User.model.SignInUser;
import com.green.feedextra.User.model.User;
import com.green.feedextra.common.CustomFileUtils;
import com.green.feedextra.common.model.SignInRes;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper mapper;
    private final CustomFileUtils customFileUtils;

    @Transactional
    @Operation(summary = "회원가입을 할 수 있습니다 ", description = "회원가입을 할 수 있다.")
    public  int insUser(MultipartFile pic, insUser p ){
        System.out.println(pic);
        String saveFileNames = customFileUtils.makeRandomFileName(pic);
        p.setPic(saveFileNames);
        String hashedPw = BCrypt.hashpw(p.getUpw(), BCrypt.gensalt());
        p.setUpw(hashedPw);
        int result = mapper.insUser(p);

        if(pic == null){
            return result;
        }
        System.out.println("asdaasasdasdasdasdsa");
        try {
            String path = String.format("user/%d",p.getUserId());
            System.out.println(path);
            customFileUtils.makeFolders(path);
            String target = String.format("%s/%s/",path,saveFileNames);
            System.out.println(target);
            customFileUtils.transferTo(pic,target);

        }catch (Exception e){
            e.printStackTrace();
            throw  new RuntimeException("집가고싶다");
        }
        return result;
    }

    public SignInRes SignInUser(SignInUser p){
        User user = mapper.SignInUser(p.getUid());

        if(user == null){
            throw new RuntimeException("아이디확인좀");
        }
        if (!BCrypt.checkpw(p.getUpw(),user.getUpw())){
            throw new RuntimeException("비번틀림");
        }
        return   SignInRes.builder()
                .userId(user.getUserId())
                .nm(user.getNm())
                .pic(user.getPic()).build();

    }
}
