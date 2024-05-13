package com.green.feedextra.User;


import com.green.feedextra.User.model.insUser;
import com.green.feedextra.User.model.SignInUser;
import com.green.feedextra.common.CustomFileUtils;
import com.green.feedextra.common.ResultDto;
import com.green.feedextra.common.model.SignInRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/user")
@RestController
@Tag(name = "집가고싶다")
public class UserController {
    private final UserService service;
    private final CustomFileUtils customFileUtils;

    @PostMapping("sign-up")
    @Operation(summary = "회원가입을 할 수 있습니다 ", description = "회원가입을 할 수 있다.")
    public ResultDto<Integer> insUser(@RequestPart(required = false) MultipartFile pic, @RequestPart insUser p){
        int result = service.insUser(pic , p);
        return   ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("회원가입 성공 ")
                .resultData(result).build();

    }
    @PostMapping("sign-in")
    @Operation(summary = "로그인 하자",description = "")
    public ResultDto<SignInRes> SignInUser(@RequestBody SignInUser p){
        SignInRes result = service.SignInUser(p);
        return ResultDto.<SignInRes>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("로그인성공")
                .resultData(result).build();

    }
}
