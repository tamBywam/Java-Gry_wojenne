package grywojenne;

import java.util.ArrayList;
import java.util.List;

public class Secretary {
    private List<String> reports = new ArrayList<>();

    public void logAction(String action) {
        reports.add(action);
        System.out.println(action);
    }

    public List<String> getReports() {
        return reports;
    }

    public void printReports() {
        for (String report : reports) {
            System.out.println(report);
        }
    }
}
