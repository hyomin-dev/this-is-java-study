package ch17.sec06.pratice.map_to_obj_int;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Run {
    public static void main(String[] args) {
        int[] arrInt = {1,2,3,4,5};
        IntStream stream = IntStream.of(arrInt);
        List<Student> list;

        list = stream
                .mapToObj(n->new Student(n*10))
                .collect(Collectors.toList());

        for(Student s : list)
            System.out.println(s);

    }
}
class Student{
    private int grade1;


    public Student(){};

    public Student(int grade1){
        this.grade1 = grade1;

    }

    public int getGrade1(){
        return this.grade1;
    }

   @Override
    public String toString(){
        return "Student{"+
                "성적: "+this.grade1+"}";
   }
}