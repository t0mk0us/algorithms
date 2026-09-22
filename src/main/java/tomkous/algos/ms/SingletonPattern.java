package tomkous.algos.ms;

public class SingletonPattern {

    private static SingletonPattern instance;

    private SingletonPattern() {
        // Optional: Perform any initialization here
    }

    public static SingletonPattern getInstance() {
        if (instance == null) {
        	
            synchronized (SingletonPattern.class) {

            	if (instance == null) {
                    instance = new SingletonPattern();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from the Singleton instance!");
    }
}