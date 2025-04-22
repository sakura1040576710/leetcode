package design_pattern.singleton;

public class Singleton2 {
    private static volatile Singleton2 singleton = null;

    private Singleton2() {
    }

    public static Singleton2 getSingleton() {
        if (singleton == null) {
            Class var0 = Singleton2.class;
            synchronized(Singleton2.class) {
                if (singleton == null) {
                    singleton = new Singleton2();
                }
            }
        }

        return singleton;
    }

    public static void main(String[] args) {
        Singleton2 s1 = getSingleton();
        Singleton2 s2 = getSingleton();
        System.out.println(s1 == s2);
    }
}

