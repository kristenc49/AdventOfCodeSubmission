
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/input.txt");
        ArrayList<String> left = new ArrayList<>();
        ArrayList<String> right = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++) {
            String[] segments = fileData.get(i).split("   ");
            left.set(i, segments[0]);
            right.set(i, segments[1]);
        }
    //    System.out.println(fileData);
        System.out.println(left);
        System.out.println(right);
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }

}
