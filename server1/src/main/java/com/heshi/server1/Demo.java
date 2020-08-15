package com.heshi.server1;

import com.google.common.io.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * @Author: fukun
 * @Date: 2020/8/12 8:38
 * @since
 */
public class Demo {
    private static Logger logger = LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) {
        String msJdk = "D:\\Java\\jdk1.8.0_192\\bin";
        logger.info(copyJavaExe(msJdk, "baseSet"));
    }

    private static String copyJavaExe(String msJdk, String serviceCode) {
        File sourceFile = new File(msJdk + File.separator + "java.exe");
        File targetFile = new File(msJdk + File.separator + "bap-cloud" + File.separator + serviceCode + ".exe");
        try {
            Files.createParentDirs(targetFile);
            Files.copy(sourceFile, targetFile);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        if (targetFile.exists()) {
            return targetFile.getAbsolutePath();
        } else {
            return sourceFile.getAbsolutePath();
        }
    }
}
