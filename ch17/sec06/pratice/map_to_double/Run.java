package ch17.sec06.pratice.map_to_double;

import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(10,33));
        list.add(new Student(20,44));
        list.add(new Student(30,56));

        double avg = list.stream()
                .mapToDouble(s->{
                    return (double)(s.getGrade1()+ s.getGrade2())/3;
                }).sum();

        System.out.println(avg);
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