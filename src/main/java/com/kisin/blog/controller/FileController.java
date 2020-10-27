package com.kisin.blog.controller;

import com.kisin.blog.result.Result;
import com.kisin.blog.utils.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import static com.kisin.blog.result.ResultCode.FAILURE;
import static com.kisin.blog.result.ResultCode.SUCCESS;

@RestController
public class FileController {

    @CrossOrigin
    @PostMapping(value = "/api/admin/cover-upload")
    @ResponseBody
    public Result fileUpload(MultipartFile file) {
        String path = "C:/Users/Administrator/Server/files";
        File imagePath = new File(path);
        File f = new File(imagePath, StringUtils.getRandomString(10) + file.getOriginalFilename());
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
        try {
            file.transferTo(f);
            String imageURL = "/api/file/" + f.getName();
            return new Result(SUCCESS, imageURL);
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(FAILURE, "");
        }
    }
}
