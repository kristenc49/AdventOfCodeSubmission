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

        for (int i = 0; i < data.length(); i ++) {
            int num1=0;
            if (data.substring(i, i + 4).equals("mul(")) {
                if ((isNumeric(data.substring(i+4,i+5))) && (isNumeric(data.substring(i+5, i+6))) && (isNumeric(data.substring(i+6,i+7))) && data.substring(i+7,i+8).equals(",")) {
                    num1 = Integer.parseInt(data.substring(i+4,i+7));
                } else if ((isNumeric(data.substring(i+4,i+5))) && (isNumeric(data.substring(i+5, i+6)) && data.substring(i+7,i+8).equals(",")) ){
                    num1 = Integer.parseInt(data.substring(i+4,i+6));
                } else if ((isNumeric(data.substring(i+4,i+5))) && data.substring(i+7,i+8).equals(",")) {}
                    num1 = Integer.parseInt(data.substring(i+4, i+5));
            }
        }

    }

    public static boolean isNumeric(String x) {
        boolean numeric = true;
        try {
            Double num = Double.parseDouble(x);
        } catch (NumberFormatException e) {
            numeric = false;
        }
        return numeric;
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