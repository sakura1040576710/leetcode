import java.io.*;
import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
//        Say s=new Child();
//        Person p=new Child();
//        s.say();
//        p.say();
//        Integer[] a=new Integer[]{1,2,3};
//        change(a);
//        System.out.println(Arrays.toString(a));
//        String a="ab";
//        String b="a"+"b";
//        String c=new String("ab");
//        System.out.println(a==b);
//        System.out.println(a==c);

//        new Address().clone();
    }

    static class Address implements Cloneable{
        private String province;
        private String city;
        private String area;
        //省略构造函数和setter/getter

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static void change(Integer[] a){
        a[0]=10;
    }

    interface Say{
        void say();
    }

    static class Person implements Say{

        @Override
        public void say() {
            System.out.println("person");
        }
    }

    static class Child extends  Person implements Say{
        @Override
        public void say() {
            System.out.println("child");
        }
    }
}