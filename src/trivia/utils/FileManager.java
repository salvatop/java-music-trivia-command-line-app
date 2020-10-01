/*
####################### FileManager class #######################
A small utility to create/update/delete/ a file on the file system

@ createDirectory(String path) // create a directory in the file system given a path(eg ./ current dir)
@ createFile(String fileName) // create
@ writeFile(String fileName, String data) //  write
@ readFile(String fileName) //  read
@ deleteFile(File fileName) //  delete
@ displayFileInfo(File fileName) // output a string containing the file name,
the absolute path if the file is writeable or readable  and file size.
################################################################
 */
package trivia.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class FileManager {

    public static String createFile(String fileName){
        try {
            File file = new File(fileName);
            if(file.createNewFile()) return "File created: " + file.getName() + "\n" + file.getAbsolutePath();
            else return "File already exists.\n" + file.getAbsolutePath();
        } catch (Exception e) {
            System.out.println("*****************************\n\n");
            e.printStackTrace();
            
            System.out.println("*****************************\n\n");
            return "An error occurred on creating to the file.";
        }
    }
    public static void writeFile(String fileName, String data) throws IOException {
        try {
            File file = new File(fileName);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(data);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("*****************************\n\n");
            e.printStackTrace();
            System.out.println("*****************************\n\n");
        }
    }
    public static String readFile(String fileName) {
        try {
            File file = new File(fileName);
            StringBuilder sb = new StringBuilder();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                sb.append(data);
            }
            scanner.close();
            return sb.toString();
        } catch (FileNotFoundException e) {
            System.out.println("*****************************\n\n");
            e.printStackTrace();
            System.out.println("*****************************\n\n");
            return "An error occurred on reading the file.";
        }
    }
    public static String displayFileInfo(File fileName) {
        if (fileName.exists()) {
            System.out.println();
            return "File name: " + fileName.getName() +
                    "\nAbsolute path: " + fileName.getAbsolutePath() +
                    "\nWriteable: " + fileName.canWrite() +
                    "\nReadable " + fileName.canRead() +
                    "\nFile size in bytes " + fileName.length() + " or in kilobytes " + ((double) fileName.length() / 1024);

        } else {
            System.out.println("*****************************\n\n");
            System.out.println("The file does not exist.");
            System.out.println("*****************************\n\n");
            return "The file does not exist.";
        }
    }
    public static String deleteFile(File fileName) {
        if (fileName.delete()) return "Deleted the file: " + fileName.getName();
        else return "Failed to delete the file.";
    }
    public static String createDirectory(String path){
        File file = new File(path);
        if(file.mkdir()) return "Directory created successfully";
        else return "Sorry could not create the specified directory";
    }

    public static void updateFile(String filename, String newData){
        try {
            Files.write(Paths.get(filename), newData.getBytes(),
                    StandardOpenOption.APPEND);
        } catch (IOException ex) {
            ex.printStackTrace(); }
    }
}