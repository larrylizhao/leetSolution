package Sort;

import java.util.Arrays;
import java.util.Comparator;

public class Sort {
    //年龄比较器
    Comparator<student> comparatorAge =new Comparator <student>(){
        public int compare(student p1,student p2){
            if (p1.getAge()>p2.getAge())
                return 1;
            else if (p1.getAge()<p2.getAge())
                return -1;
            else
                return 0;
        }
    };

    //成绩比较器
    Comparator<student> comparatorGrade =new Comparator <student>(){
        public int compare(student p1,student p2){
            if (p1.getGrade()>p2.getGrade())
                return 1;
            else if (p1.getGrade()<p2.getGrade())
                return -1;
            else
                return 0;
        }
    };

    public student [] ageSort(student[] s){
        Arrays.sort(s,comparatorAge);
        return s;
    }

    public student [] gradeSort(student[] s){
        Arrays.sort(s,comparatorGrade);
        return s;
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        student p1 = new student() ;
        p1.setAge( 10 );
        p1.setName( "p1" );
        p1.setGrade( 98 );

        student p2 = new student() ;
        p2.setAge( 30 );
        p2.setName( "p2" );
        p2.setGrade( 70 );

        student p3 = new student() ;
        p3.setAge( 20 );
        p3.setName( "p3" );
        p3.setGrade( 83 );

        student p4 = new student() ;
        p4.setAge( 15 );
        p4.setName( "p4" );
        p4.setGrade( 80 );

        student [] list = {p1,p2,p3,p4} ;

        //按年龄排序
        student[] agePrint = sort.ageSort(list);
        for (student ss : agePrint) {
            System.out.println("student age sort ," + ss.getName() + "  " + ss.getAge() +" " +ss.getGrade());
        }

        //按成绩排序
        student[] gradePrint = sort.gradeSort(list);
        for (student ss : gradePrint) {
            System.out.println("student grade sort ," + ss.getName() + "  " + ss.getAge() +" " +ss.getGrade());
        }
    }

}

//创建一个类型，用于比较的引用对象类型
class student{
    private String name;
    private int age;
    private float grade;

    public void setName(String name){
        this.name=name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getGrade() {
        return grade;
    }
}
