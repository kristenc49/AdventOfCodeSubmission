import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        ArrayList<String> fileData = getFileData("src/Day2Input.txt");
        for (String line : fileData) {
            boolean safe = false;
            String[] lineNums = line.split(" ");
            if (isIncreasing(lineNums) || isDecreasing(lineNums) || increasingSBR(lineNums) || decreasingSBR(lineNums)) {
                if (increment3(lineNums)) {
                    safe = true;
                }
            }

            if (safe) {
                count++;
            }
        }

        System.out.println(count);

    }


    public static boolean isIncreasing(String[] arr) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (String str : arr) {
            nums.add(Integer.parseInt(str));
        }
        int count = 0;
        for (int i = 0; i < nums.size()-1; i++) {
            if (nums.get(i) < nums.get(i+1)) {
                count++;
            }
        }
        if ((count == nums.size() - 1)) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean increasingSBR(String[] arr) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (String str : arr) {
            nums.add(Integer.parseInt(str));
        }
        int count = 0;
        for (int i = 0; i < nums.size()-1; i++) {
            if (nums.get(i) < nums.get(i+1)) {
                count++;
            }
        }
        if ((count == nums.size() - 2)) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isDecreasing(String[] arr) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (String str : arr) {
            nums.add(Integer.parseInt(str));
        }
        int count = 0;
        for (int i = 0; i < nums.size()-1; i++) {
            if (nums.get(i) > nums.get(i+1)) {
                count++;
            }
        }
        if ((count == nums.size() - 1)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean decreasingSBR(String[] arr) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (String str : arr) {
            nums.add(Integer.parseInt(str));
        }
        int count = 0;
        for (int i = 0; i < nums.size()-1; i++) {
            if (nums.get(i) > nums.get(i+1)) {
                count++;
            }
        }
        if ((count == nums.size() - 2)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean increment3(String[] arr) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (String str : arr) {
            nums.add(Integer.parseInt(str));
        }

        int count = 0;
        for (int i = 0; i < nums.size()-1; i++) {
            if (Math.abs(nums.get(i) - nums.get(i+1)) < 4 && Math.abs(nums.get(i) - nums.get(i+1)) > 0) {
                count++;
            }
        }

        if (!increasingSBR(arr) && !decreasingSBR(arr)) {
            if ((count == nums.size() - 2)) {
    return true;
            }
        }

        if ((count == nums.size() - 1)) {
            return true;
        } else {
            return false;
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