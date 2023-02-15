
import java.util.Scanner;

class program{
    public static void main(String[] args){
        calculator a = new calculator();
        a.run();
    }
}

class calculator{
    Scanner keyboard = new Scanner(System.in);
    double memory[]={};
    int i = 0;
    void run(){
        String text = keyboard.nextLine();
        double value = inter.eval(text);
        System.out.println(value);
        memory[i] = value;
        i++;
    }
}
