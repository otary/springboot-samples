package cn.chenzw.springboot.integration.file.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class TransformUtils {

    public static final String transformFileToString(File file) {
        System.out.println("-------------------:" + file);
       /* try {
            return FileUtils.readFileToString(file, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        return "--------------------";
    }
}
