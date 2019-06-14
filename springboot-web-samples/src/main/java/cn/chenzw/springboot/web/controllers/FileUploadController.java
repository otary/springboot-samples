package cn.chenzw.springboot.web.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/upload")
public class FileUploadController {


    @PostMapping("/")
    public void upload(){

    }
}
