package ch17.sec06.pratice.map;

import ch08.sec10.exam01.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Run {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(10));
        list.add(new Person(20));
        list.add(new Person(30));

        List<Student> listS;
        Stream<Person> streamP = list.stream();
        listS = streamP.
                map(p-> {
                    return new Student("학생", p.getAge());
                }).
                collect(Collectors.toList());

        for(Student s : listS)
            System.out.println(s);
    }
}

class Student{
    private int age;
    private String name;

    public Student(){}

    public Student(String name, int age){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class Person{
    private int age;

    public Person(){}

    public Person(int age){
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }

}
