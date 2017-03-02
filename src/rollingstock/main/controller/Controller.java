package rollingstock.main.controller;

import rollingstock.main.model.*;
import rollingstock.main.view.UIView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Controller {
    private RollingStock stock;
    private UIView view = new UIView();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void run() {
        this.printToConsole("Current timetable of trains:\n" +
                RollingStock.getAllStocks().keySet() + "\n");
        while (true) {
            try {
                printToConsole("Input targeted direction (print 'exit' to end):");
                String direction = readString();
                if (direction.equalsIgnoreCase("exit")) {
                    return;
                }
                stock = getStockByDirection(direction);
                printToConsole("Input range of count of passengers 'from' - 'to': (both inclusive)");
                int from = Integer.parseInt(readString());
                int to = Integer.parseInt(readString());
                printToConsole("Total cont of passengers and baggage: " + getTotalCountPassAndBaggs() + "\n");
                printToConsole("View coaches by comfort level:\n" + sortStockByComfortLevel() + "\n");
                printToConsole("View coaches by count range:\n" + getCoachesByPassRange(from, to) + "\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public RollingStock getStockByDirection(String direction) {
        return new RollingStock(direction);
    }

    public List<Wagon> sortStockByComfortLevel() {
        List<Wagon> list = new ArrayList<>();
        for (Wagon wagon : stock.getStock()) {
            if (wagon instanceof PassengerCoach) {
                list.add(wagon);
            }
        }
        Collections.sort(list, new Comparator<Wagon>() {
            @Override
            public int compare(Wagon o1, Wagon o2) {
                return o2.getComfortLevel() - o1.getComfortLevel();
            }
        });
        return list;
    }

    public int getTotalCountPassAndBaggs() {
        int result = 0;
        for (Wagon wagon : stock.getStock()) {
            if (wagon instanceof PassengerCoach) {
                result += ((PassengerCoach) wagon).getCountOfPassengers();
            }
            if (wagon instanceof BaggageVan) {
                result += ((BaggageVan) wagon).getCountOfBaggage();
            }
        }
        return result;
    }

    public List<Wagon> getCoachesByPassRange(int fromCount, int toCount) {
        List<Wagon> list = new ArrayList<>();
        if (fromCount < 0 || toCount < 0 || fromCount > toCount) {
            printToConsole("Incorrect data");
            return null;   //??
        }
        for (Wagon wagon : stock.getStock()) {
            if (wagon instanceof PassengerCoach) {
                if (((PassengerCoach) wagon).getCountOfPassengers() >= fromCount
                        || ((PassengerCoach) wagon).getCountOfPassengers() <= toCount) {
                    list.add(wagon);
                }
            }
        }
        return list;
    }

    public void printToConsole(String message) {
        view.writeToConsole(message);
    }
    public void printToFile(String message) {
        view.writeToFile(message);
    }
    public static String readString() throws IOException {
        return reader.readLine();
    }
}