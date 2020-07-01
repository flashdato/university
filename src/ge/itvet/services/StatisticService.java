package ge.itvet.services;

import ge.itvet.university.Subject;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
                                    .map( (Map.Entry<Subject, Integer> subjectPointEntry) -> subjectPointEntry.getValue())
                                    .reduce(Integer::sum);
                            return Map.entry(entry.getKey(), reduce.get());
                        }
                ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return typeIntegerMap;
    }
}
