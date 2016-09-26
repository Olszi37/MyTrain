package com.olszi.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.*;
import java.util.Iterator;

/**
 * Created by MOlszi on 2016-09-22.
 */

@Controller
public class FileUpload {

    public File upload(MultipartHttpServletRequest request) throws UnsupportedEncodingException {

        request.setCharacterEncoding("utf-8");

        Iterator<String> iterator = request.getFileNames();
        MultipartFile multipartFile = request.getFile(iterator.next());

        File directory = makeUploadDirectory(request);

        File file = null;

        try{
            byte[] bytes = multipartFile.getBytes();

            file = new File(directory.getAbsolutePath()+ File.separator + multipartFile.getName());

            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));
            outputStream.write(bytes);
            outputStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }

    public File makeUploadDirectory(MultipartHttpServletRequest request){

        String path = request.getServletContext().getRealPath("/");

        File directory = new File(path + "/uploads");

        if(!directory.exists()){
            directory.mkdirs();
        }

        return directory;
    }
}
