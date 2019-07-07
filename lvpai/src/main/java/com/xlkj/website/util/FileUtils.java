package com.xlkj.website.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Slf4j
public class FileUtils {

    public static void save(MultipartFile file, String relativePath, String newFileName) throws IOException {
        save(file.getInputStream(), relativePath, newFileName+getFileSuffix(file,false));
    }

    public static void save(InputStream in, String relativePath, String newFileName) throws IOException {
        File dir = new File(relativePath);
        FileOutputStream outFile = null;
        try {
            if (!dir.exists() || !dir.isDirectory()) {
                dir.mkdirs();
            }
            outFile = new FileOutputStream(new File(dir, newFileName));
            FileCopyUtils.copy(in, outFile);
            System.out.println("文件存储到了新地方, path="+relativePath);
        } finally {
            if (null != outFile) {
                outFile.flush();
                outFile.close();
            }
        }

    }

    public static File find(String filePath, String fileid) throws IOException {
        File dir = new File(filePath);
        if (dir.exists() && dir.isDirectory()) {
            File file = new File(dir, fileid);
            if (file.exists() && file.canRead()) {
                return file;
            } else {
                throw new IOException();
            }
        } else {
            throw new FileNotFoundException();
        }
    }


    /**
     * 文件后缀
     *
     * @param file
     * @return .txt
     */
    public static String getFileSuffix(MultipartFile file, boolean hasSpot) {
        int spotIndex = 0;
        if (hasSpot) {
            spotIndex = 1;
        }
        return file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + spotIndex);
    }

    public static String getFileSuffix(String fileName, boolean hasSpot) {
        int spotIndex = 0;
        if (hasSpot) {
            spotIndex = 1;
        }
        return fileName.substring(fileName.lastIndexOf(".") + spotIndex);
    }


}
