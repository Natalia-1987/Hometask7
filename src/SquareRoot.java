import java.sql.SQLOutput;

@FunctionalInterface

public interface SquareRoot {
    abstract double findSquareRoot(int a);
    default void display(){
        System.out.println("Demonstration");
    }
    default void anotherDisplay(){
        System.out.println("Another demonstarion");
    }
    static void show(){
        System.out.println("The functional interface can have only one abstract method");
    }
}
