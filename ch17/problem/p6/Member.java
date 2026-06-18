package ch17.problem.p6;

public class Member {
    private String name;
    private int age;

    public Member(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){return this.name;}

    public int getAge(){return this.age;}
}
