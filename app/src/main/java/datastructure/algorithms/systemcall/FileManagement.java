package datastructure.algorithms.systemcall;

import java.io.*;
import java.nio.charset.Charset;

public class FileManagement {

    public static void main(String[] args) {
        final var fileName = "systemcall.txt";
        final var fileContents = "write something";
        createFile(fileName);
        writeFile(fileName, fileContents);
        String contents = readFile(fileName);
        System.out.println("==read contents==");
        System.out.println(contents);
    }

    private static void createFile(final String fileName) {
        File file = new File(fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("file created : " + file.getName());
            } else {
                System.out.println("file already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeFile(final String fileName, final String contents) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(contents);
            System.out.println("Success to write contents");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(String fileName) {
        try (BufferedReader br = new BufferedReader(
                new FileReader(fileName, Charset.defaultCharset()),
                32 * 1024
        ) ) {
            StringBuilder contents = new StringBuilder();
            String temp;
            while ((temp = br.readLine()) != null) {
                contents.append(temp);
            }

            return contents.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
