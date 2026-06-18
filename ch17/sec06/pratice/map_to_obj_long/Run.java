package ch17.sec06.pratice.map_to_obj_long;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Run {
    public static void main(String[] args) {
        long[] arrLong = {1L,2L,3L,4L,5L};


        List<Student> list;

        list = LongStream.of(arrLong)
                .mapToObj(n->new Student(n*10))
                .collect(Collectors.toList());

        for(Student s: list)
            System.out.println(s);
    }
}
class Student{
    private long grade1;


    public Student(){};

    public Student(long grade1){
        this.grade1 = grade1;

    }

    public long getGrade1(){
        return this.grade1;
    }

    @Override
    public String toString(){
        return "Student{"+
                "성적: "+this.grade1+"}";
    }
}