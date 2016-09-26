package com.olszi.controller;

import com.olszi.model.Trainset;
import com.olszi.service.TrainsetService;
import com.olszi.system.FileUpload;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
            Trainset trainset = new Trainset();

            for(Cell cell : row){
                if(cell.getColumnIndex() != 0 && cell.getRowIndex() != 0){
                    if(cell.getColumnIndex() == 1)
                        trainset.setName(cell.getStringCellValue());
                    if(cell.getColumnIndex() == 2)
                        trainset.setNickname(cell.getStringCellValue());
                }
            }

            trainsets.add(trainset);
        }

        return trainsets;
    }
}
