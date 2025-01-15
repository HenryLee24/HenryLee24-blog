import java.io.*;

public class FileInfoDemo {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Usage : java FileInfoDemo <filename>");
            System.exit(1);
        }

        File file = new File(args[0]);
        if(file.exists()) {
            System.out.println(file.exists());
            System.out.println("Filename : " + file.getName());
            System.out.println("Size : " + file.length());
        } else {
            System.out.println(args[0] + " does not exist.");
        }
    }
}
    