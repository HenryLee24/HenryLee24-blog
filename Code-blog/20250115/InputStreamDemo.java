import java.io.*;

public class InputStreamDemo {
    public static void main(String[] args) {
        try {
            System.out.println("Please enter with keyboard and press [Enter]. ");
            System.out.println("Please enter [Ctrl] + Z (Windows) or [Ctrl] + D (Linux/Mac) to end the program. ");

            int b;
            while((b = System.in.read()) != -1) {
                System.out.write(b);
                System.out.println();
                System.out.println("byte(numerical) representation : " + b);
                System.out.println("char representation: " + (char)b);
                System.out.println(" --- ");
            }
            System.out.println();
        } catch(IOException e) {
            System.err.println(e);
            System.exit(1);
        }
    }
}
