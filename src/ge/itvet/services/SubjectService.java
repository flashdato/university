package ge.itvet.services;
import ge.itvet.university.Subject;
import java.util.List;

public class SubjectService {
    private List<Subject> subjects;
    {
        subjects.add(new Subject(Subject.Type.TECHNICAL,"Calculus"));
        subjects.add(new Subject(Subject.Type.TECHNICAL,"SQL"));
        subjects.add(new Subject(Subject.Type.TECHNICAL,"Java"));
        subjects.add(new Subject(Subject.Type.TECHNICAL,"HTML/CSS"));
        subjects.add(new Subject(Subject.Type.HUMANITARIAN,"Psychology"));
        subjects.add(new Subject(Subject.Type.HUMANITARIAN,"History"));
    }

    public List<Subject> getSubjects()
    {
        return subjects;
    }
}
