package org.example;

// Singleton pattern is used for logging, drivers objects, caching, and thread pool
class EagerInitializationSingleton {

// drawback:
// 1. the object will be created even when getInstance() is not called. If the singleton class is using
// lots of resources(File System, Database connections) then it would be waste of resources.
// 2. Can't do exception handling(Will throw compile time error - "Unexpected token")
    private static final EagerInitializationSingleton object = new EagerInitializationSingleton();

    EagerInitializationSingleton(){

    }

    public static EagerInitializationSingleton getInstance(){
        return object;
    }

}

class StaticBlockSingleton{

    // Do the initialization in static block. Now we can do exception handling as well.
    private static StaticBlockSingleton object;

    StaticBlockSingleton(){

    }
    static{
        try{
            object = new StaticBlockSingleton();
        }catch(Exception e){
            System.out.println("caught exception");
        }
    }


}

class LazyInitializationSingleton{

    // pros: object will be created only when it is needed.
    // cons: not thread safe, multiple obj could be created if multiple threads reaches if block at same time
    private static LazyInitializationSingleton object;

    public LazyInitializationSingleton getInstance(){
        if(object == null)
            object = new LazyInitializationSingleton();

        return object;
    }
}

class ThreadSafeSingleton{
    private static ThreadSafeSingleton object;

    ThreadSafeSingleton(){}

    // Implementation 1 : making method as synchronized such that only one thread will use this method.
    // cons: it reduces the performance because of the cost associated with the synchronized method,
    //       although we need it only for the first few threads that might create separate instances.
    public static synchronized ThreadSafeSingleton getInstance(){
        if(object == null)
            object = new ThreadSafeSingleton();

        return object;
    }

    // Implementation 2: To remove this overhead we use double-checked locking principle
    // the synchronized block is used inside the if condition with an additional check to
    // ensure that only one instance of a singleton class is created
    public static ThreadSafeSingleton getInstanceUsingDoubleCheckedLocking(){
        if(object == null){
            synchronized (SingletonPattern.class){
                object = new ThreadSafeSingleton();
            }
        }

        return object;
    }
}

class BillPughSingletonImplementaion{
    BillPughSingletonImplementaion(){};

    private static class SingletonHelper{
        private static BillPughSingletonImplementaion object = new BillPughSingletonImplementaion();
    }

    public static BillPughSingletonImplementaion getInstance(){
        return SingletonHelper.object;
    }

    /*
    Notice the private inner static class that contains the instance of the singleton class.
    When the singleton class is loaded, SingletonHelper class is not loaded into memory and
    only when someone calls the getInstance() method, this class gets loaded and creates the
    singleton class instance. This is the most widely used approach for the singleton class as
    it does not require synchronization.
     */
}

public class SingletonPattern {


}
