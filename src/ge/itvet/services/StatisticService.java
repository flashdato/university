package ge.itvet.services;

import ge.itvet.university.Group;
import ge.itvet.university.Student;
import ge.itvet.university.Subject;
import jdk.jshell.spi.ExecutionControl;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StatisticService {
    private static final GroupService service = new GroupService();

    public Map<Subject.Type, Integer> sumOfPointsGroupBySubjectType() {
        Map<Subject.Type, List<Map.Entry<Subject, Integer>>> collect =
                service.getGroups().stream()
                        .flatMap(group -> group.getStudents().stream())
                        .flatMap(student -> student.getPoints().entrySet().stream())
                        .collect(Collectors.groupingBy(entry -> entry.getKey().getType()));

        Map<Subject.Type, Integer> typeIntegerMap =
                collect.entrySet().stream()
                        .map((Map.Entry<Subject.Type, List<Map.Entry<Subject, Integer>>> entry) -> {
                                    Optional<Integer> reduce =
                                            entry.getValue().stream()
                                                    .map(Map.Entry::getValue)
                                                    .reduce(Integer::sum);
                                    return Map.entry(entry.getKey(), reduce.get());
                                }
                        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return typeIntegerMap;
    }

    public Map<Subject.Type, Integer> sortGroupByType() {
        long size = service.getGroups().stream()
                .flatMap(group -> group.getStudents().stream()).count();
        Map<Subject.Type, Integer> typeIntegerMap = sumOfPointsGroupBySubjectType();
        typeIntegerMap.replaceAll((s, v) -> v / (int) size);
        return typeIntegerMap.entrySet()
                .stream()
                .sorted((Map.Entry.<Subject.Type, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    }

    public List<Group> sortBySubject(final Subject subject) {
        Map<Group, List<Student>> collect = service.getGroups().stream()
                .collect(Collectors.toMap(a -> a, Group::getStudents));

        return
                collect.entrySet().stream()
                        .map(groupListEntry -> Map.entry(groupListEntry.getKey(), groupListEntry.getValue().stream()
                                .map(student -> student.getPointsBySubject(subject))
                                .reduce(0, Integer::sum) / groupListEntry.getValue().size()))
                        .sorted((e1, e2) -> e2.getValue() - e1.getValue())
//                       .peek(System.out::println)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());

    }
}

