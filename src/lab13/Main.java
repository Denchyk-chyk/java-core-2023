package lab13;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("John", 50000.0),
                new Employee("Alice", 48000.0),
                new Employee("Bob", 52000.0),
                new Employee("Catherine", 55000.0),
                new Employee("David", 49000.0),
                new Employee("Eva", 51000.0),
                new Employee("Frank", 53000.0),
                new Employee("Henry", 54000.0),
                new Employee("Ivy", 46000.0),
                new Employee("Jack", 52000.0),
                new Employee("Karen", 50000.0),
                new Employee("Leo", 48000.0),
                new Employee("Mia", 51000.0),
                new Employee("Nathan", 49000.0),
                new Employee("Olivia", 53000.0),
                new Employee("Paul", 55000.0),
                new Employee("Quinn", 47000.0),
                new Employee("Ryan", 54000.0),
                new Employee("Sara", 46000.0)
        };

        Stream<Double> stream = Stream.of(employees).map(e -> e.getSalary());
        double sum = stream.reduce(0d, (a, b) -> a + b);
        double count = employees.length;
        System.out.println(sum/count);

        System.out.println(Arrays.stream(employees).map(e -> e.getSalary()).reduce(0d, (a, b) -> a + b) / employees.length);

        System.out.println((Arrays.stream(employees).mapToDouble(Employee::getSalary).average().getAsDouble()));
    }
}