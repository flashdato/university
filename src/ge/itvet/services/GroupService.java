package ge.itvet.services;

import ge.itvet.university.Group;

import java.util.List;

public class GroupService {
    private String[] names = {"Thanos","Captain America","Iron Man","Black widow"};
    private List<Group> groups;
    private StudentService studentService;
    private SubjectService subjectService;
    {
        for (String name : names) {
            Group group = new Group();
            group.setName(name);
            group.addStudents(studentService.getStudents(4));
            group.addSubjects(subjectService.getSubjects());
        }
    }
}
