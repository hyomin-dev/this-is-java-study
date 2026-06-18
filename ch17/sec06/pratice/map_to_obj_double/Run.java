package ch17.sec06.pratice.map_to_obj_double;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Run {
    public static void main(String[] args) {
        double[] arrDouble = {1.1,2.2,3.3,4.4,5.5};
        List<Student> list;

        list = DoubleStream.of(arrDouble)
                .mapToObj(n->new Student(n))
                .collect(Collectors.toList());

        for(Student s : list)
            System.out.println(s);
    }
}
class Student{
    private double grade1;


    public Student(){};

    public Student(double grade1){
        this.grade1 = grade1;

    }

    public double getGrade1(){
        return this.grade1;
    }

    @Override
    public String toString(){
        return "Student{"+
                "성적: "+this.grade1+"}";
    }
}