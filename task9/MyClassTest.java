package fmi.informatics.task9;

import fmi.informatics.extending.Student;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyClassTest {
    private int resultat = 0;
    @org.junit.Test
    public void edno() {
        Student[] studentsArr = new Student[]{Student.StudentGenerator.make()};
        Stream.of(Student.StudentGenerator.make(),
                Student.StudentGenerator.make(),
                Student.StudentGenerator.make())
                .filter(s -> s.getName().length() >= 5)
                .sorted((s2, s1) -> s1.getName().compareTo(s2.getName()))
                .forEach(System.out::println);

        Assert.assertEquals("The student Stoyan is learning in BIT speciality", studentsArr[0].toString());
    }

    @org.junit.Test
    public void dve() {
        String[] cars = {"Lamborghini", "Ferrari", "Lada", "Chaika"};
        Stream.of(cars)
                .map(String::toUpperCase)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        Assert.assertEquals("Lamborghini", cars[0]);
    }

    @org.junit.Test
    public void tri() {
        List<Student> studs = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            studs.add(Student.StudentGenerator.make());
        }
        String studNames = studs.stream()
                .sorted((s2, s1) -> s1.getName().compareTo(s2.getName()))
                .map(s -> s.getName())
                .reduce((s1, s2) -> {
                    if (s2 != null) return s1 + ", " + s2;
                    return s1;
                })
                .get();
        System.out.println(studNames);
        Assert.assertEquals(studNames, "Petya, Lilly, Stoyan, Ivan");
    }



    @org.junit.Test
    public void chetiri() {
        IntStream.iterate(0, i -> i + 1)
                .skip(5)
                .limit(10)
                .forEach(i -> {
                    if (i % 2 == 0) {
                        System.out.println(i);
                    }
                    resultat = i;
                });
        Assert.assertEquals(12, resultat);
    }
}