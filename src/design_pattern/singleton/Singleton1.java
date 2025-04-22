package design_pattern.singleton;

public class Singleton1 {
    private static Singleton1 singleton = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getSingleton() {
        return singleton;
    }

    public static void main(String[] args) {
        Singleton1 s1 = getSingleton();
        Singleton1 s2 = getSingleton();
        System.out.println(s1 == s2);
    }
}