package com.green.feedextra.common;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Component
@Getter
public class CustomFileUtils {
    private final String uploadPath; // 객체화가 끝난다음에 final이 되기떄문에 이대로 사용 불가능
    // DI
    public CustomFileUtils(@Value("${file.directory}")String uploadPath) {
        this.uploadPath = uploadPath;
    }
    public String makeFolders(String path){
        File folder = new File(uploadPath,path);
        folder.mkdirs();
        return folder.getAbsolutePath();
    }
    // UUID 랜덤 파일명
    public String makeRandomFileName(){
        return UUID.randomUUID().toString();
    }
    //파일명에서  확장자 얻어오기
    public String getExt(String fileName){
        //abcde.ddd.jpg 중에 jpg를 가져와야한다
//        int idx = fileName.indexOf("cd"); //  왼쪽에서 찾고자 함 찾고자하는 곳에 점이 있다면 양수값 없으면 -1 값
        int idx2 = fileName.lastIndexOf("."); //오른쪽에서 찾고자 함 찾고자하는 곳에 점이 있다면 양수값 없으면 -1 값
        System.out.println("idx2 : "+idx2);
        String[] str = fileName.split("\\.");
        System.out.println("srt ." + str[str.length -1]);
        return fileName.substring(idx2);
    }

    // 랜덤 파일명 with 확장자 만들기
    public String makeRandomFileName(String fileName){ // fileName 원본 에 확장자 랜덤한 파일명 리턴

        return makeRandomFileName() +getExt(fileName);
    }
    //랜덤파일명 with 확장자 만들기 using MultipartFile
    public String makeRandomFileName(MultipartFile mf){
        return mf == null ? null : mf.isEmpty() ? null: makeRandomFileName(mf.getOriginalFilename());


    }
    // 파일저장  target 는 경로랑 파일명까지 지정 된상태
    public  void transferTo(MultipartFile mf , String target ) throws Exception {
        File saveFile = new File(uploadPath , target); // 죄종경로

        mf.transferTo(saveFile);
    }
}
