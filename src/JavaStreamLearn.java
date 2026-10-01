import java.util.*;
import java.util.stream.*;

public class JavaStreamLearn {
    public static void main(String[] args) {
        ArrayList<String> ar = new ArrayList<>(List.of("Mardon", "Chel", "Schinobu", "Da"));

        ar.stream().min(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()))
                .ifPresent(System.out::println); // нахоождение мин значения
        ar.stream().filter(s -> s.length() < 5).forEach(System.out::println); // пример форич
        ar.stream().reduce((a,b)->a+b).ifPresent(System.out::println);//склеивание в одно
        String redRes = ar.stream().reduce("",(a,b)->a+b); // вариация со стартовой точкой
        String parRes=ar.parallelStream().unordered().reduce("",(a,b)->a+b,(a,b)->a+b);
        ar.stream().map((a)->a+"!").forEach(System.out::println); // мап элементов (сопоставление)
        ar.stream().mapToInt(String::length).forEach(System.out::println); // перевод в инт



    }
}
