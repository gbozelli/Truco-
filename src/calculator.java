package src;
import java.util.Scanner;

public class calculator{
    Scanner keyboard = new Scanner(System.in);
    double memory[]= new double[100];
    int i = 0;
    void run(){
        String text = keyboard.nextLine();
        double value = evaluate.eval(text);
        System.out.println(value);
        memory[i] = value;
        i++;
    }
    void interrupt(){
        
    }
}