import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day2Input.txt");

        int count = 0;
        for (int i = 0; i < fileData.size(); i++) {
            boolean increasing = false;
            String[] array = fileData.get(i).split(" ");
          //  for (int j = 1; j < array.length-1; j++) {
            int j = 1;
            while (!increasing && j < array.length) {
                if (Integer.parseInt(array[j]) > Integer.parseInt(array[j - 1])) {
                    increasing = true;
                }
                j++;
            }

            boolean decreasing = false;
            int x = 1;
            while (!decreasing && x < array.length) {
                if (Integer.parseInt(array[x]) < Integer.parseInt(array[x - 1])) {
                    decreasing = true;
                }
                x++;
            }
            if (increasing || decreasing) {
                int count2 = 0;
                for (int n = 0; n < array.length - 1; n++) {
                    int num = Math.abs(Integer.parseInt(array[n]) - Integer.parseInt(array[n+1]));
                    if (num < 1 || num > 3) {
                        count2++;
                    }
                }

                if (count2 == 0) {
                    count++;
                }
            }
        //    }
        }

        System.out.println(count);

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