package cz.spsmb.source;

public class Singleton {

    private static int instanceCount;
    private static Singleton singleton = new Singleton();

    public static Singleton getSingleton() {
        return singleton;
    }

    public static int getInstanceCount() {
        return instanceCount;
    }

    private Singleton() {
        if (singleton != null) {
            throw new InstantiationError( "Creating of this object is not allowed." );
        } else Singleton.instanceCount++;
    }

    public String getMessage() {
        return "Hello";
    }
}
