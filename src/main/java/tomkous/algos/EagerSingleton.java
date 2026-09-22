package tomkous.algos;

public class EagerSingleton {
    // Instance is created during class loading
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() {}

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}

