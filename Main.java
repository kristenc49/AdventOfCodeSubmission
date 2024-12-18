import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day1Input.txt");

        int calibrated = 0;
        for (int i = 0; i < fileData.size(); i++) {
            boolean operated = false;
            String solution = "";
            int x = 0;
            while (!fileData.get(i).substring(x,x+1).equals(":")) {
                solution += fileData.get(i).substring(x, x+1);
                x++;
            }

            int numSolution = Integer.parseInt(solution);

            String[] nums = fileData.get(i).substring(x + 1).split(" ");

            if (multiply(nums) == numSolution) {
                operated = true;
            }

            if (add(nums) == numSolution) {
                operated = true;
            }

            if (operated) {
                calibrated += numSolution;
            }

        }

        System.out.println(calibrated);

    }


    public static int multiply(String[] nums) {
        int product = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            product += Integer.parseInt(nums[i]) * Integer.parseInt(nums[i+1]);
        }

        return product;
    }

    public static int add(String[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
             sum += Integer.parseInt(nums[i]) + Integer.parseInt(nums[i+1]);
        }

        return sum;
    }

    public boolean combos(String[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int currentNum = Integer.parseInt(nums[i]);
            for (int x = 0; x < nums.length; i++) {
                currentNum * 
            }
        }
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