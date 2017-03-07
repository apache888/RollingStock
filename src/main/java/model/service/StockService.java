package model.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import bean.Wagon;
import emulDB.DBCreator;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by Roman Hayda on 07.03.2017.
 */

public class StockService {
    @JsonDeserialize(keyAs=String.class, contentAs=ArrayList.class)
    private Map<String, List<Wagon>> timetable = new HashMap<>();
    private FileReader fileReader;
    ObjectMapper mapper = new ObjectMapper();

//    public StockService() {
//        try {
//            fileReader = new FileReader("G:\IdeaProjects\RollingStock\src\main\java\emulDB\\timetable.json");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    /*Получение карты всех направлений из базы данных*/
    public Map<String, List<Wagon>> getTimetable() {
        try {
            File dir = new File("G:\\IdeaProjects\\RollingStock\\src\\main\\java\\emulDB\\timetable");
            File[] files = dir.listFiles();
            for (File file : files) {
                fileReader = new FileReader(file);
                String name = file.getName().replaceAll(".json", "");
                List<Wagon> list = mapper.readValue(fileReader, ArrayList.class);
                timetable.put(name, list);
            }
//            timetable =(Map<String, List<Wagon>>) mapper.readValue(fileReader, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return timetable;
    }
}
