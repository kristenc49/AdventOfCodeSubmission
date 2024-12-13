import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/day3input.txt");
        String data = "";
        for (int i = 0; i < fileData.size(); i++) {
            data += fileData.get(i);
        }
        int sum = 0;
        boolean enabled = true;
        for (int i = 0; i < data.length() - 11; i++) {
            int num1=0;
            int num2=0;
            if (data.substring(i, i + 7).equals("don't()")) {
                enabled = false;
            }

            if (data.substring(i, i + 4).equals("do()")) {
                enabled = true;
            }
            if (data.substring(i, i + 4).equals("mul(")) {
                if ((isNumeric(data.substring(i+4,i+5))) && (isNumeric(data.substring(i+5, i+6))) && (isNumeric(data.substring(i+6,i+7))) && data.substring(i+7,i+8).equals(",")) {
                    num1 = Integer.parseInt(data.substring(i+4,i+7)); // num1 3 digits
                    if ((isNumeric(data.substring(i+8,i+9))) && (isNumeric(data.substring(i+9, i+10))) && (isNumeric(data.substring(i+10,i+11))) && data.substring(i+11,i+12).equals(")")) {
                        num2 = Integer.parseInt(data.substring(i+8,i+11)); // 3:3
                        if (enabled) {
                            sum += num1 * num2;
                        }
                    } else if ((isNumeric(data.substring(i+8,i+9))) && (isNumeric(data.substring(i+9, i+10))) && data.substring(i+10,i+11).equals(")")){
                        num2 = Integer.parseInt(data.substring(i+8,i+10)); // 3:2
                        if (enabled) {
                            sum += num1 * num2;
                        }
                    } else if ((isNumeric(data.substring(i+8,i+9))) && data.substring(i+9,i+10).equals(")")) {
                        num2  = Integer.parseInt(data.substring(i+8, i+9)); // 3:1
                        if (enabled) {
                            sum += num1 * num2;
                        }
                    }
                } else if ((isNumeric(data.substring(i+4,i+5))) && (isNumeric(data.substring(i+5, i+6)) && data.substring(i+6,i+7).equals(",")) ) {
                    num1 = Integer.parseInt(data.substring(i + 4, i + 6)); // num1 2 digits
                    if ((isNumeric(data.substring(i + 7, i + 8))) && (isNumeric(data.substring(i + 8, i + 9))) && (isNumeric(data.substring(i + 9, i + 10))) && data.substring(i + 10, i + 11).equals(")")) {
                        num2 = Integer.parseInt(data.substring(i + 7, i + 10)); // 2:3
                        if (enabled) {
                            sum += num1 * num2;
                        }
                    } else if ((isNumeric(data.substring(i + 7, i + 8))) && (isNumeric(data.substring(i + 8, i + 9))) && data.substring(i + 9, i + 10).equals(")")) {
                        num2 = Integer.parseInt(data.substring(i + 7, i + 9)); // 2:2
                        if (enabled) {
                            sum += num1 * num2;
                        }
                    } else if ((isNumeric(data.substring(i + 7, i + 8))) && data.substring(i + 8, i + 9).equals(")")) {
                        num2 = Integer.parseInt(data.substring(i + 7, i + 8)); // 2:1
                        if (enabled) {
                            sum += num1 * num2;
                        }
                    }
                } else if ((isNumeric(data.substring(i+4,i+5))) && data.substring(i+5,i+6).equals(",")) {}
                num1 = Integer.parseInt(data.substring(i+4, i+5)); // num1 1 digit
                if ((isNumeric(data.substring(i + 6, i + 7))) && (isNumeric(data.substring(i + 7, i + 8))) && (isNumeric(data.substring(i + 8, i + 9))) && data.substring(i + 9, i + 10).equals(")")) {
                    num2 = Integer.parseInt(data.substring(i + 6, i + 9)); // 1:3
                    if (enabled) {
                        sum += num1 * num2;
                    }
                } else if ((isNumeric(data.substring(i + 6, i + 7))) && (isNumeric(data.substring(i + 7, i + 8))) && data.substring(i + 8, i + 9).equals(")")) {
                    num2 = Integer.parseInt(data.substring(i + 6, i + 8)); // 1:2
                    if (enabled) {
                        sum += num1 * num2;
                    }
                } else if ((isNumeric(data.substring(i + 6, i + 7))) && data.substring(i + 7, i + 8).equals(")")) {
                    num2 = Integer.parseInt(data.substring(i + 6, i + 7)); // 1:1
                    if (enabled) {
                        sum += num1 * num2;
                    }
                }
            }

        }

        System.out.println(sum);

    }

    public static void checkNum2() {

    }
    public static boolean isNumeric(String x) {
       if (x.equals("0") || x.equals("1") || x.equals("2") || x.equals("3") || x.equals("4") || x.equals("5") || x.equals("6") || x.equals("7") || x.equals("8") || x.equals("9")) {
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