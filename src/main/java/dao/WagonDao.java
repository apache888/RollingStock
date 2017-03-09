package dao;

import model.Wagon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Create by Roman Hayda on 08.03.2017.
 */
public class WagonDao {
    private String dataSource = "src\\main\\java\\db";
    private File dir = new File(dataSource);
    private BufferedReader reader;

    public int getTotalCount() {
        int result = 0;
        String str;
        try {
            for (File file : dir.listFiles()) {
                reader = new BufferedReader(new FileReader(file));
                str = reader.readLine(); // при условии, что файл состоит из одной строки и 4х элементов
                String[] elements = str.split(", ");
                int x = Integer.parseInt(elements[2].substring(elements[2].indexOf("=") + 1));
                int y = Integer.parseInt(elements[3].substring(elements[3].indexOf("=") + 1));
                result += (x + y);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Wagon> getSortStockByCL() {
        List<Wagon> list = getAllWagons();

        Collections.sort(list, new Comparator<Wagon>() {
            @Override
            public int compare(Wagon o1, Wagon o2) {
                return o2.getComfortLevel() - o1.getComfortLevel();
            }
        });
        return list;
    }

    public List<Wagon> getStockByCountRange(int from, int to) {
        List<Wagon> list = new ArrayList<>();
        for (Wagon wagon : getAllWagons()) {
            if (wagon.getCountPass() >= from
                    && wagon.getCountPass() <= to) {
                list.add(wagon);
            }
        }
        return list;
    }


    public List<Wagon> getAllWagons() {
        List<Wagon> list = new ArrayList<>();
        String str;
        if (dir == null) {
            return null;
        }
        try {
            for (File file : dir.listFiles()) {
                reader = new BufferedReader(new FileReader(file));
                str = reader.readLine(); // при условии, что файл состоит из одной строки и 4х элементов
                String[] elements = str.split(", ");
                int id = Integer.parseInt(elements[0].substring(elements[0].indexOf("=") + 1));
                int comfortLevel = Integer.parseInt(elements[1].substring(elements[1].indexOf("=") + 1));
                int countPass = Integer.parseInt(elements[2].substring(elements[2].indexOf("=") + 1));
                int countBaggs = Integer.parseInt(elements[3].substring(elements[3].indexOf("=") + 1));
                Wagon wagon = new Wagon();
                wagon.setId(id);
                wagon.setComfortLevel(comfortLevel);
                wagon.setCountPass(countPass);
                wagon.setCountBaggs(countBaggs);
                list.add(wagon);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
