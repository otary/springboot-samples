package cn.chenzw.springboot.web.controllers;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping("/upload")
public class FileUploadController {

    private static final String UPLOAD_PATH = Thread.currentThread().getContextClassLoader().getResource("").getPath();

    /**
     * 单文件上传
     * <p>
     * 必须要@RequestParam参数指定才能获取到参数值
     *
     * @param uploadFile
     */
    @PostMapping("")
    public void upload(@RequestParam("file") MultipartFile uploadFile, @RequestParam("userName") String userName) throws IOException {

        // 字段名
        String name = uploadFile.getName();  // => "file"

        // 获取文件名
        String fileName = uploadFile.getOriginalFilename();
        String fileExtName = FilenameUtils.getExtension(fileName);

        log.info("upload => name: {}, FileName: {}, FileExtNam: {}, userName: {}", name, fileName, fileExtName, userName);

        File file = new File(UPLOAD_PATH, fileName + "_upload");

        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        // 写入文件
        uploadFile.transferTo(file);

        // 写入方式二
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

            log.info("upload => FileName: {}, FileExtNam: {}", fileName, fileExtName);

            // 使用NIO写入
            byte[] bytes = item.getBytes();
            Path path = Paths.get(UPLOAD_PATH + item.getOriginalFilename());
            Files.write(path, bytes);
        }
    }
}
