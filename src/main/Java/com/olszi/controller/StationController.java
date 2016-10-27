package com.olszi.controller;

import com.olszi.model.Station;
import com.olszi.service.StationService;
import com.olszi.system.FileUpload;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MOlszi on 2016-09-10.
 */

@CrossOrigin
@RestController
@RequestMapping(value = "station")
public class StationController {

    @Autowired
    private StationService stationService;

    @Autowired
    private FileUpload fileUpload;

    @RequestMapping(value = "get/all", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Station> getAllStations(){
        return stationService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "set/file", headers = "Content-Type=multipart/*")
    public @ResponseBody int setStationsByFile(MultipartHttpServletRequest request) throws IOException, InvalidFormatException {

        File file = fileUpload.upload(request);
        List<Station> stations = getFileData(file);

        for(Station station : stations){
            stationService.create(station);
        }

        return stations.size();
    }

    public List<Station> getFileData(File file) throws IOException, InvalidFormatException {

        List<Station> stations = new ArrayList<Station>();

        Workbook workbook = WorkbookFactory.create(file);

        for(Row row : workbook.getSheetAt(0))
        {
            if(row.getRowNum() != 0)
            {
                Station station = new Station();

                station.setStationID((long) row.getCell(0).getNumericCellValue());
                station.setName(row.getCell(1).getStringCellValue());
                station.setProvince(row.getCell(2).getStringCellValue());

                stations.add(station);
            }
        }

        return stations;
    }
}
