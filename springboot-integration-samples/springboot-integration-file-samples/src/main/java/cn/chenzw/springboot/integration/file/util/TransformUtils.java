package cn.chenzw.springboot.integration.file.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class TransformUtils {

    /**
     * 读取文件
     *
     * @param file
     * @return
     */
    public static final String transformFileToString(File file) {
        try {
            return FileUtils.readFileToString(file, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
