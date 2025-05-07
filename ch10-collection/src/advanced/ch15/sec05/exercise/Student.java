package advanced.ch15.sec05.exercise;

public class Student implements Comparable<Student>{
    public int number;
    public String name;
    public String email;
    public String git;

    public Student(int number, String name, String email, String git) {
        this.number = number;
        this.name = name;
        this.email = email;
        this.git = git;
    }

    //number 기준으로 정렬
//    @Override
//    public int compareTo(Student o) {
//        if(this.number < o.number)
//            return -1;
//        else if(this.number > o.number)
//            return 1;
//        else return 0;
//    }


    //name 기준 정렬
//    @Override
//    public int compareTo(Student o) {
//        return this.name.compareTo(o.name);
//    }

    //email 기준으로 정렬
    @Override
    public int compareTo(Student o) {
        return this.email.compareTo(o.email);
    }

}
