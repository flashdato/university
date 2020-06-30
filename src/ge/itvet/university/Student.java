package ge.itvet.university;

import java.util.Map;

public class Student extends Person {
    private Map<Subject,Integer> points ;
    public void addPoint(Subject subject,int point)
    {
        points.put(subject,point);
    }

}
