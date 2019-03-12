package main.java.com.thoughtWorks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyFile {
    private File myfile;
    private Scanner myReader;

    ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    private ArrayList<String> data = new ArrayList<>();

    MyFile(String myfile) {
        this.myfile = new File(myfile);
        try {
            myReader = new Scanner(this.myfile);
            while (myReader.hasNextLine()) {
                data.add(myReader.nextLine());
            }
            System.out.println(data);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File can not be open!");
            e.printStackTrace();
        }
    }

    public File getMyfile() {
        return myfile;
    }

    public void setMyfile(File myfile) {
        this.myfile = myfile;
    }

    @Override
    public String toString() {
        return "MyFile{" +
                "myfile=" + myfile +
                '}';
    }

    public Scanner getMyReader() {
        return myReader;
    }

    public void setMyReader(Scanner myReader) {
        this.myReader = myReader;
    }
}
