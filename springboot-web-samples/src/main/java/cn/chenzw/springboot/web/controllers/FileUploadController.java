package cn.chenzw.springboot.web.controllers;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 文件上传示例
 */
@RestController
@RequestMapping("/upload")
public class FileUploadController {

    private static final String UPLOAD_PATH = Thread.currentThread().getContextClassLoader().getResource("").getPath();

    /**
     * 单文件上传
     *
     * @param uploadFile
     */
    @PostMapping("")
    public void upload(@RequestParam("file") MultipartFile uploadFile) throws IOException {
        // 获取文件名
        String fileName = uploadFile.getOriginalFilename();
        String fileExtName = FilenameUtils.getExtension(fileName);

        File file = new File(UPLOAD_PATH, fileName);

        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        // 写入文件
        uploadFile.transferTo(file);


        // FileUtils.writeByteArrayToFile(file, uploadFile.getBytes());
    }

    /**
     * 多文件上传
     *
     * @param uploadFiles
     * @throws IOException
     */
    @PostMapping("/multiple")
    public void multipleUpload(@RequestParam("file") MultipartFile[] uploadFiles) throws IOException {
        for (MultipartFile item : uploadFiles) {
            if (item.getSize() <= 0) {
                return;
            }
            // 获取文件名
            String fileName = item.getOriginalFilename();
            String fileExtName = FilenameUtils.getExtension(fileName);

            // 使用NIO写入
            byte[] bytes = item.getBytes();
            Path path = Paths.get(UPLOAD_PATH + item.getOriginalFilename());
            Files.write(path, bytes);

        }
    }
}
