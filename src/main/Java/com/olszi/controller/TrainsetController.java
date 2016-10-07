package com.olszi.controller;

import com.olszi.model.Trainset;
import com.olszi.service.TrainsetService;
import com.olszi.system.FileUpload;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MOlszi on 2016-09-24.
 */

@RestController
@RequestMapping(value = "trainset")
public class TrainsetController {

    @Autowired
    private TrainsetService trainsetService;

    @Autowired
    private FileUpload fileUpload;

    @RequestMapping(method = RequestMethod.POST, value = "set/file", headers = "Content-Type=multipart/*")
    public @ResponseBody List<Trainset> setTrainsets(MultipartHttpServletRequest request) throws IOException, InvalidFormatException {

        File file = fileUpload.upload(request);
        List<Trainset> trainsets = getData(file);

        for (Trainset trainset : trainsets){
            trainsetService.create(trainset);
        }

        return trainsets;
    }

    public List<Trainset> getData(File file) throws IOException, InvalidFormatException {

        List<Trainset> trainsets = new ArrayList<Trainset>();

        Workbook workbook = WorkbookFactory.create(file);

        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet){
            if(row.getRowNum() != 0){
                Trainset trainset = new Trainset();

                trainset.setNumber(row.getCell(1).getStringCellValue());
                trainset.setName(row.getCell(2).getStringCellValue());

                trainsets.add(trainset);
            }
        }

        return trainsets;
    }
}
