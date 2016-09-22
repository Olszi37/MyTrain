package com.olszi.controller;

import com.olszi.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by MOlszi on 2016-09-10.
 */

@RestController
@RequestMapping(value = "station")
public class StationController {

    static String REPOSITORY_PATH;

    @Autowired
    private StationService stationService;

    @RequestMapping(method = RequestMethod.POST, value = "set/upload", headers = "multipart/*")
    public void setStationsByFile(MultipartHttpServletRequest request){

        File file = uploadFile(request);
    }

    public File uploadFile(MultipartHttpServletRequest request){

        Iterator<String> iterator = request.getFileNames();
        MultipartFile multipartFile = request.getFile(iterator.next());

        String path = request.getServletContext().getRealPath("/");

        File directory = new File(path + "/uploads");

        if(!directory.exists()){
            directory.mkdirs();
        }

        REPOSITORY_PATH = directory.getPath();

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
}
