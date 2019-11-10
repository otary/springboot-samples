package cn.chenzw.springboot.integration.sftp.gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.remote.FileInfo;

import java.io.File;
import java.util.List;

@MessagingGateway
public interface SftpGateway {

    @Gateway(requestChannel = "lsChannel")
    List<FileInfo> listFile(String dir);

    @Gateway(requestChannel = "downloadChannel")
    List<File> downloadFiles(String dir);

    @Gateway(requestChannel = "uploadChannel")
    void uploadFile(File file);

}
