package ch17.sec06.pratice.map_to_long;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Run {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(10,30));
        list.add(new Student(20,40));
        list.add(new Student(30,50));

        Stream<Student> stream = list.stream();
        LongStream streamInt = stream.mapToLong(s->{
            return s.getGrade1()+s.getGrade2();
        });


       Long total = streamInt.sum(); // int type을 대입했으면 오류 생김
       System.out.println(total);
    }
}

class Student{
    private int grade1;
    private int grade2;

    public Student(){};

    public Student(int grade1, int grade2){
        this.grade1 = grade1;
        this.grade2 = grade2;
    }

    public int getGrade1(){
        return this.grade1;
    }

    public int getGrade2(){
        return this.grade2;
    }
}