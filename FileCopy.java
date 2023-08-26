// Author: Nathan Hutton
// This program creates a duplicate of a file (first command line argument) with the name specified (second command line argument)

import java.io.File;
import java.io.FileInputStream;

public class FileCopy {

    public static void main(String[] args) throws Exception {
        // ========================
        // CHECK ALL FAIL CONDITONS
        // ========================

        if (args.length != 2)
            throw new Exception("Invalid number of command line arguments given");

        if (args[0].equals(args[1]))
            throw new Exception("First argument and second argument cannot be the same");

        // I got the information up to and including the next 2 if statements from this link:
        // https://www.edureka.co/community/101325/how-do-i-check-if-a-file-exists-in-java
        // by searching "how to check if a file exists as a string java"

        //FileInputStream input_stream = new FileInputStream(args[0]);
        File file_to_copy = new File(args[0]);

        if (!file_to_copy.exists())
            throw new Exception(file_to_copy + " does not exist");

        if (file_to_copy.isDirectory())
            throw new Exception(file_to_copy + " is a directory");

        // ========================
        // MAIN LOOP
        // ========================
        
        byte[] bytes = new byte[(int) file_to_copy.length()];
        
        // using a try block ensures that the FileInputStream is closed
        try (FileInputStream input_stream = new FileInputStream(file_to_copy)) {
            input_stream.read(bytes);
        }
        
    }

}
