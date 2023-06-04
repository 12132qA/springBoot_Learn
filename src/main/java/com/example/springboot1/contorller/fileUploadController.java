package com.example.springboot1.contorller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
public class fileUploadController {
    @PostMapping("/upload")                //    javaEE中获取前端请求信息的接口
    public String upFile(String nickname, MultipartFile photo, HttpServletRequest request) throws IOException {
        System.out.println(nickname);
        // 获取图片的原始名称
        System.out.println(photo.getOriginalFilename());
        // 取文件类型
        System.out.println(photo.getContentType());
        // 获取服务器路径信息
        String path = request.getServletContext().getRealPath("/upload/");
        System.out.println(path);
        //
        saveFile(photo,path);
        return "上传成功";
    }

    //                    文件上传          获取路径
    public void saveFile(MultipartFile photo,String path) throws IOException {
//       判断存储的目录是否存在，如果不存在则创建
        File dir = new File(path);
        if(!dir.exists()){
//          创建目录  文件夹
            dir.mkdir();  // 文件路径随机  易变化
        }

        File file = new File(path+photo.getOriginalFilename()); // 写入服务器中
        photo.transferTo(file); // 网络资源存储到路径中
    }
}
