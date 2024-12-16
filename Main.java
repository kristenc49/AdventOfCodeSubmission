import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/day4input.txt");
        String input = "";
        for (int i = 0; i < fileData.size(); i++) {
            input += fileData.get(i);
        }

        int i = 0;
        String[][] crossword = new String[fileData.size()][fileData.get(0).length()];
        for (int r = 0; r < crossword[0].length; r++) {
            for (int c = 0; c < crossword.length; c++) {
                crossword[r][c] = input.substring(i, i+1);
                i++;
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