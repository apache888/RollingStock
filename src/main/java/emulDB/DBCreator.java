package emulDB;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import bean.BaggageVan;
import bean.Locomotive;
import bean.PassengerCoach;
import bean.Wagon;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Create by Roman Hayda on 07.03.2017.
 */
/*Класс, эмулирующий загрузку составов по направлениям в базу данных*/
public class DBCreator {
//    private String timetable = "G:\IdeaProjects\RollingStock\src\main\java\emulDB\\timetable.json";
    private String timetable = "G:\\IdeaProjects\\RollingStock\\src\\main\\java\\emulDB\\timetable";
//    private FileWriter writer = new FileWriter(timetable);
    private FileWriter writer;
    private ObjectMapper mapper = new ObjectMapper();

//    @JsonDeserialize(keyAs=String.class, contentAs=ArrayList.class)
//    Map<String, List<Wagon>> map = new HashMap<>();
    @JsonDeserialize(as=ArrayList.class)
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="type")
        @JsonSubTypes({
                @JsonSubTypes.Type(value=Locomotive.class, name="locom"),
                @JsonSubTypes.Type(value=PassengerCoach.class, name="coach"),
                @JsonSubTypes.Type(value=BaggageVan.class, name="van")
        })
    List<Wagon> list = new ArrayList<>();

    /*Создание базы данных*/
    public void createDB() throws IOException {
        writer = new FileWriter(timetable + "\\Odessa-Kiev.json");
        list.add(new Locomotive(5, 0));
        for (int i = 1; i < 11; i++) {
            list.add(new PassengerCoach((int) (Math.random() * 100 / 2), i));
        }
        for (int i = 11; i < 15; i++) {
            list.add(new BaggageVan((int) (Math.random() * 10 * i), i));
        }
//        map.put("Odessa-Kiev", list);
        mapper.writeValue(writer, list);

        writer = new FileWriter(timetable + "\\Odessa-Lvov.json");list.clear();
        list.add(new Locomotive(3, 0));
        for (int i = 1; i < 10; i++) {
            list.add(new PassengerCoach((int) (Math.random() * 100 / 2), i));
        }
        for (int i = 10; i < 13; i++) {
            list.add(new BaggageVan((int) (Math.random() * 10 * i), i));
        }
//        map.put("Odessa-Lvov", list);
//        mapper.writeValue(writer, map);
        mapper.writeValue(writer, list);
    }

    public static void main(String[] args) {
        try {
            new DBCreator().createDB();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
