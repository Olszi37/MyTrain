package com.olszi.controller;

import com.olszi.model.Station;
import com.olszi.service.StationService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * Created by MOlszi on 2016-09-10.
 */

@RestController
@RequestMapping(value = "station")
public class StationController {

    @Autowired
    private StationService stationService;

    @RequestMapping(method = RequestMethod.POST, value = "set/upload")
    public void setStationsByFile(HttpServletRequest httpServletRequest){

        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        diskFileItemFactory.setSizeThreshold(1024*1024*3);
        diskFileItemFactory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload fileUpload = new ServletFileUpload();

        String uploadPath = httpServletRequest.getServletContext().getRealPath("") + File.separator + "upload";

        try {
            List<FileItem> items = fileUpload.parseRequest(httpServletRequest);

            if(items != null && items.size() > 0){
                for (FileItem item : items){
                    if(!item.isFormField()){
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);

                        item.write(storeFile);
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
