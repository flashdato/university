package ge.itvet.university;

import java.util.HashMap;
import java.util.Map;

public class Student extends Person {
    private Map<Subject, Integer> points = new HashMap<>();

    public void addPoint(Subject subject, int point) {
        points.put(subject, point);
    }

    public Map<Subject, Integer> getPoints() {
        return points;
    }
}
