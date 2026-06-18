package ch15.Problem.P8;

public class Student {
    public int studentNum;
    public String name;

    public Student (int studnetNum, String name){
        this.studentNum = studnetNum;
        this.name = name;
    }

    // 여기에 코드를 작성
    @Override
    public int hashCode(){
        return studentNum;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Student s){
            return (studentNum==s.studentNum);
        }
        else
            return false;
    }
}
