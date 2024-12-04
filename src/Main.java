import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/input.txt");
        ArrayList<String> left = new ArrayList<>();
        ArrayList<String> right = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++) {
            left.add(fileData.get(i).split("   ")[0]);
            right.add(fileData.get(i).split("   ")[1]);
        }

        Collections.sort(left);
        Collections.sort(right);

        int score = 0;
        for (int i = 0; i < left.size(); i++) {
            int count = 0;
            for (int j = 0; j < right.size(); j++) {
                if (Integer.parseInt(left.get(i)) == Integer.parseInt(right.get(j))) {
                    count++;
                }
            }
            score += (Integer.parseInt(left.get(i)) * count);
        }

        System.out.println(score);

//        ArrayList<Integer> differences = new ArrayList<>();
//        for (int i = 0; i < left.size(); i++) {
//            int num1 = Integer.parseInt(left.get(i));
//            int num2 = Integer.parseInt(right.get(i));
//            differences.add(Math.abs(num1-num2));
//        }

//        int sum = 0;
//        for (int i = 0; i < differences.size(); i++) {
//            sum += differences.get(i);
//        }
//
//        System.out.println(sum);
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