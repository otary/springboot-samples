package cn.chenzw.springboot.integration.sftp.controllers;

import cn.chenzw.springboot.integration.sftp.gateway.SftpGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.file.remote.FileInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/sftp")
public class SftpController {

    @Autowired
    SftpGateway sftpGateway;

    @GetMapping("/list")
    public String list() {
        List<FileInfo> fileInfos = sftpGateway.listFile("/");

        return fileInfos.toString();
    }

    @GetMapping("/download")
    public String download() {
        List<File> files = sftpGateway.downloadFiles("/testdir");
        return files.toString();
    }

    @GetMapping("/upload")
    public void upload() {
        URL resource = Thread.currentThread().getContextClassLoader().getResource("file/u.txt");
        sftpGateway.uploadFile(new File(resource.getFile()));
    }
}
