package com.olszi.controller;

import com.olszi.model.Carriage;
import com.olszi.model.CarriageType;
import com.olszi.model.Trainset;
import com.olszi.service.CarriageService;
import com.olszi.service.TrainsetService;
import com.olszi.system.FileUpload;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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
 * Created by MOlszi on 2016-09-27.
 */

@RestController
@RequestMapping(value = "carriage")
public class CarriageController {

    @Autowired
    private CarriageService carriageService;
    @Autowired
    private FileUpload fileUpload;
    @Autowired
    private TrainsetService trainsetService;


    @RequestMapping(method = RequestMethod.POST, value = "set/file", headers = "Content-Type=multipart/*")
    public @ResponseBody List<Carriage> setCarriagesByFile(MultipartHttpServletRequest request) throws IOException, InvalidFormatException {

        File file = fileUpload.upload(request);
        List<Carriage> carriages = getDataFromFile(file);

        for(Carriage carriage : carriages){
            carriageService.create(carriage);
        }

        return carriages;
    }

    public List<Carriage> getDataFromFile(File file) throws IOException, InvalidFormatException {

        List<Carriage> carriages = new ArrayList<Carriage>();

        Workbook workbook = WorkbookFactory.create(file);

        List<Trainset> trainsets = trainsetService.getAll();

        for(Row row : workbook.getSheetAt(0)){
            if(row.getRowNum() != 0)
            {
                Carriage carriage = new Carriage();

                carriage.setTrainset(trainsets.get((int) row.getCell(1).getNumericCellValue() - 1));
                carriage.setNumber((int) row.getCell(2).getNumericCellValue());
                carriage.setType(CarriageType.values()[(int) row.getCell(3).getNumericCellValue()]);

                carriages.add(carriage);
            }
        }

        return carriages;
    }
}
