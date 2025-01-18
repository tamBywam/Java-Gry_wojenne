package grywojenne;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Secretary implements Serializable {
    private List<String> reports = new ArrayList<>();

    public void logAction(String action) {
        reports.add(action);
    }

    public List<String> getReports() {
        return reports;
    }
}
