package ge.itvet;

import ge.itvet.services.ExamService;
import ge.itvet.services.StatisticService;
import ge.itvet.university.Subject;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        new ExamService();
        StatisticService statisticService = new StatisticService();
        Map<Subject.Type, Integer> typePointsMap = statisticService.sumOfPointsGroupBySubjectType();
        System.out.println("typePointsMap = " + typePointsMap);

     /*
     X 1.ქულების გენერცია თითოეული გრუპის სტუდენტზე
     X 2.საგნის ტიპის მიხედვით ქულების ჯამის დაბრუნება
     3.დავალაგოთ ჯგუფები საგნების  ტიპის მიხედვით(სად უფრო მეტი საშუალო ქულაა)
     4.დავალაგოთ ჯგუფები საგნის მიხედვით(სად უფრო მეტი საშუალო ქულაა)
     5.დავალაგოთ სტუდენტები ქულების მიხედვით
     6.დავალაგოთ სტუდენტები ქულების მიხედვით(კონკრეტული საგანში)
     7.დავალაგოთ სტუდენტები ქულების მიხედვით(კონკრეტული საგნებში)*
     8.დავალაგოთ სტუდენტები ქულების მიხედვით(კონკრეტული ტიპის საგნებში)
      */
        System.out.println("THE END");
    }
}


