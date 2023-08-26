// Author: Nathan Hutton
// This program creates a duplicate of a file (first command line argument) with the name specified (second command line argument)

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileCopy {

    public static void main(String[] args) {
        // ========================
        // CHECK INTIAL FAIL CONDITONS
        // ========================

        if (args.length != 2) {
            System.out.println("Invalid number of command line arguments given");
            return;
        }

        if (args[0].equals(args[1])) {
            System.out.println("First argument and second argument cannot be the same");
            return;
        }

        // ========================
        // Main Loop
        // ========================

        try (
            FileInputStream input_stream = new FileInputStream(args[0]);
            FileOutputStream output_stream = new FileOutputStream(args[1]);
        ){
            int read_byte;
            while ((read_byte = input_stream.read()) != -1) {
                output_stream.write(read_byte);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(args[0] + " is not a file");
        }
        catch (IOException e) {
            System.out.println("An IOExcetion has occurred");
        }

    }

}
