import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ArrayOfPerson {
    private static Person[] p = new Person[]{
            new Person("Petya", 9),
            new Person("Vasya", 8),
            new Person("Katya", 12),
            new Person("Olya", 10),
            new Person("Lisa", 6)};

    public static void main(String[] args) {
        Comparator<Person> personNameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
        Comparator<Person> personAgeComparator = (o1, o2) -> o1.getAge().compareTo(o2.getAge());

        Arrays.stream(p)
                .sorted(personNameComparator)
                .forEach(System.out::println);

        System.out.println("-------------------");

        Arrays.stream(p)
                .sorted(personAgeComparator)
                .forEach(System.out::println);

        System.out.println("-------------------");

        Predicate<Person> personAgePredicate = person -> person.getAge() > 8;
        Arrays.stream(p)
                .filter(personAgePredicate)
                .forEach(System.out::println);

        System.out.println("-------------------");

        Supplier<ArrayList<String>> arrayListSupplier = () -> new ArrayList<String>();
        Arrays.stream(p)
                .collect(arrayListSupplier, (strings, person) -> strings.add(person.getName()), (strings, strings2) -> {})
                .forEach(System.out::println);
    }
}
